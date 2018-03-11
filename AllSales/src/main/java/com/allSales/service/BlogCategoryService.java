package com.allSales.service;

import java.util.List;

import com.allSales.domain.BlogCategory;

public interface BlogCategoryService {

	List<BlogCategory> findAll();
	BlogCategory findOne(Integer blogCatId);
}
