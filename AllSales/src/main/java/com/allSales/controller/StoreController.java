package com.allSales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.allSales.service.SaleService;
import com.allSales.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	SaleService saleService;
	
	@Autowired
	StoreService storeService;
	
	@GetMapping("/store/{storeId}")	
	public String showStores(@PathVariable("storeId") Integer storeId, Model model) {
		model.addAttribute("store", storeService.findOne(storeId));
		model.addAttribute("stores", storeService.getRelatedStores(storeId));
		model.addAttribute("sales", saleService.findSalesByStore(storeId));
		
		return "store";
		
	}

}
