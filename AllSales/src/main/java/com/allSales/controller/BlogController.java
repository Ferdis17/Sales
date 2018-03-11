package com.allSales.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.allSales.domain.Blog;
import com.allSales.domain.BlogCategory;
import com.allSales.service.BlogCategoryService;
import com.allSales.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	BlogCategoryService blogCategoryService;
	
	@Autowired
	BlogService blogService;
	
	@GetMapping("/post")
	public String postBlogForm(@ModelAttribute("blog")Blog blog, Model model) {
		model.addAllAttributes(blogCategoryService.findAll());
		return "BlogForm";
	}
	
	@PostMapping("/post")
	public String postBlog(@Valid Blog blog, BindingResult bindingResult, HttpServletRequest httpRequest, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("categories", blogCategoryService.findAll());
			return"BlogForm";
		}
		String rootDirectory = httpRequest.getSession().getServletContext().getRealPath("/");
		MultipartFile blogImage = blog.getImage();
		if(blogImage!=null && !blogImage.isEmpty()) {
			try {
				blogImage.transferTo(new File(rootDirectory +"/resources/images/blogs/" + blog.getTitle() + ".JPG"));
			}catch(Exception e) {
				throw new RuntimeException("Blog image saving failed", e);
			}
		}
		BlogCategory blogCatgory = blogCategoryService.findOne(blog.getBlogCategory().getId());
		blog.setBlogCategory(blogCatgory);
		
		blogService.save(blog);
		
		return "redirect:/home";
			
	}
	
	@GetMapping(value = "/detail/{id}")
	public String blogDetail(@PathVariable("id") Long id,Model model) {
		model.addAttribute("blog", blogService.findOne(id));
		return "blogDetail";
	}
	@GetMapping(value = {"/catgories/{categoryId}"})
	public String listBlog(@PathVariable("categoryId") Integer categoryId, Model model) {
		if(categoryId == 0) {
			model.addAttribute("blogs", blogService.findAll());
		} else {
			model.addAttribute("blogs", blogService.findBlogByCategory(categoryId));
		}
		model.addAttribute("categories", blogCategoryService.findAll());
		return "blogList";
	}
}
