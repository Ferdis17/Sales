package com.allSales.service;

import java.util.List;

import com.allSales.domain.Blog;

public interface BlogService {
	
	void save(Blog blog);
	
	Blog findOne(Long blogId);
	
	List<Blog> findAll();
	
	List<Blog> findBlogByCategory(Integer catId);

}
