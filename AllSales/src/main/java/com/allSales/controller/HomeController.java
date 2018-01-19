package com.allSales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.allSales.service.CommentService;
import com.allSales.service.SaleService;

@Controller
public class HomeController {
	
	 	@Autowired
	    SaleService saleService;

	    @Autowired
	    CommentService commentService;

	    @GetMapping({"/", "/home"})
	    public String home(Model model) {
	        model.addAttribute("featureSales", saleService.getFeatureSales());
	        model.addAttribute("frontpageSales", saleService.getFrontpageSales());

	        return "home";
	    }

}
