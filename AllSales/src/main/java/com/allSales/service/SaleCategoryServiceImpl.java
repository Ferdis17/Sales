package com.allSales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allSales.domain.SaleCategory;
import com.allSales.repository.SaleCategoryRepository;

@Service
public class SaleCategoryServiceImpl implements SaleCategoryService{

	@Autowired
	SaleCategoryRepository saleCategoryRepository;
	
	@Override
	public List<SaleCategory> findAll() {
		
		return (List<SaleCategory>) saleCategoryRepository.findAll();
	}

	@Override
	public SaleCategory findOne(Integer saleCatId) {
		
		return saleCategoryRepository.findOne(saleCatId);
	}

	@Override
	public SaleCategory getSaleCategorybyName(String saleCategoryName) {
		
		return saleCategoryRepository.getSaleCategoryByName(saleCategoryName);
	}

}
