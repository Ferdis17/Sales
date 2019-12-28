package com.allSales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allSales.domain.BlogCategory;

@Service
public interface BlogCategoryService {

	BlogCategory findOne(Integer blogCatId);
	List<BlogCategory> findAll();
}
