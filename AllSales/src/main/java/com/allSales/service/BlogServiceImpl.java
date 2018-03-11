package com.allSales.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.allSales.domain.Blog;
import com.allSales.domain.User;
import com.allSales.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	UserService userService;
	

	@Override
	public void save(Blog blog) {
		
		Date today = new Date();
		blog.setPostDate(today);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userService.findUserByEmail(email);
		
		if(user != null) {
			user.addBlog(blog);
		}
		blogRepository.save(blog);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Blog findOne(Long blogId) {
		
		return blogRepository.findOne(blogId);
	}

	@Override
	public List<Blog> findAll() {
		
		return (List<Blog>) blogRepository.findAll();
	}

	@Override
	public List<Blog> findBlogByCategory(Integer catId) {
		
		return blogRepository.findBlogByCategory(catId);
	}

}
