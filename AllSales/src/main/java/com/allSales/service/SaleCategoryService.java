package com.allSales.service;

import java.util.List;

import com.allSales.domain.SaleCategory;

public interface SaleCategoryService {
	
	List<SaleCategory> findAll();
	
	SaleCategory findOne(Integer saleId);
	
	SaleCategory getSaleCategorybyName(String saleCategoryName);

}
