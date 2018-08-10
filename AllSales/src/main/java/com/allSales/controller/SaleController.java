package com.allSales.controller;

import java.io.File;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.allSales.domain.Sale;
import com.allSales.domain.SaleCategory;
import com.allSales.domain.Store;
import com.allSales.service.SaleCategoryService;
import com.allSales.service.SaleService;
import com.allSales.service.StoreService;
import com.allSales.utils.UrlUtils;
import com.allSales.exceptionHandler.*;

@Controller
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	SaleCategoryService saleCategoryService;
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	SaleService saleService;
	
	@GetMapping("/post")
	public String postSaleForm(@ModelAttribute("sale") Sale sale, Model model) {
		model.addAttribute("categories", saleCategoryService.findAll());
		model.addAttribute("store", storeService.findAll());
		model.addAttribute("user", sale.getUser());
		model.addAttribute("comments", sale.getComments());
		return "saleForm";
	}
	
	@PostMapping("/post")
	public String postSale(@Valid Sale sale, BindingResult bindingResult, HttpServletRequest request, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", saleCategoryService.findAll());
			model.addAttribute("stores", storeService.findAll());
			return"saleForm";
		}
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		MultipartFile saleImage = sale.getSaleImage();
		if(saleImage != null && !saleImage.isEmpty()) {
			try {
				saleImage.transferTo(new File(rootDirectory + "/resources/images/sales" + sale.getSaleTitle() + ".jpg"));
			}catch(Exception e) {
				throw new RuntimeException("Sale image saving failed", e);
			}
		}
		Store store = storeService.findOne(sale.getStore().getId());
		sale.setStore(store);
		
		SaleCategory saleCategory = saleCategoryService.findOne(sale.getSaleCategory().getId());
		sale.setSaleCategory(saleCategory);
		
		saleService.save(sale);
		
		return"redirect:/sales/categories/0";
		
	}
	@GetMapping("/detail/{id}")
	public String saleDetails(@PathVariable("id") Long id, Model model) {
		Sale sale = saleService.findOne(id);
		
		if(sale == null) {
			throw new SaleNotFoundException(id);
		}
		model.addAttribute("sale", saleService.findOne(id));
		return "saleDetail";
	}
	@GetMapping(value = {"/categories/{categoryId}"})
	public String listSales(@PathVariable("categoryId") Integer categoryId, Model model) {
		if(categoryId == 0) {
			model.addAttribute("sales", saleService.findAll());
		}else {
			model.addAttribute("sales", saleService.findSalesByCategory(categoryId));
		}
		model.addAttribute("categories", saleCategoryService.findAll());
		return "salesList";
	}
	
	@ExceptionHandler(SaleNotFoundException.class)
	public String handleError(HttpServletRequest req, SaleNotFoundException exception, Model model) {
		model.addAttribute("invalidSaleId", exception.getSaleId());
		model.addAttribute("exception", exception);
		model.addAttribute("url", UrlUtils.getFullURL(req));
		
		return "saleNotFound";
	}
	
}
