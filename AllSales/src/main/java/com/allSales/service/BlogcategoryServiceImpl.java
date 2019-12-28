package com.allSales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allSales.domain.BlogCategory;
import com.allSales.repository.BlogCategoryRepository;

@Service
public class BlogcategoryServiceImpl implements BlogCategoryService{
	
	@Autowired
	BlogCategoryRepository blogCategoryRepository;

	@Override
	public List<BlogCategory> findAll() {
		
		return (List<BlogCategory>) blogCategoryRepository.findAll();
	}

	@Override
	public BlogCategory findOne(Integer blogCatId) {
		
		return blogCategoryRepository.findOne(blogCatId);
	}

}
