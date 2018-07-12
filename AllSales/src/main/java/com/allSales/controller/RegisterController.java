package com.allSales.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.allSales.domain.User;
import com.allSales.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String showRegisterForm(@ModelAttribute("user") User user) {
		
		return "register";
		
	}
	
	@PostMapping("/register")
	public String showRegisterForm(@Valid @ModelAttribute("user") User user, BindingResult results, HttpServletRequest request) {
		User existingUser = userService.findUserByEmail(user.getEmail());
		if(existingUser != null) {
			results.rejectValue("email", "Email.duplicate", "There is already a user registered with the email provided");
			
			return "register";
		}
		if(results.hasErrors()) {
			return "register";
		}
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		MultipartFile profilePicture = user.getProfilePicture();
		if(profilePicture != null && !profilePicture.isEmpty()) {
			try {
				profilePicture.transferTo(new File(rootDirectory + "/resources/images/users/" + user.getEmail() + ".jpg"));
			} catch(Exception e) {
				
				throw new RuntimeException("Profile picture saving failed", e);
				
			}
		}
		userService.save(user);
		
		return "redirect:/login";
	}
	
	@InitBinder
	public void initializeBinder(WebDataBinder binder) {
		
		binder.setAllowedFields("email", "password", "firstName", "lastName", "address.street", "address.city",
				"address.state", "address.zip", "profilePicture");
		
	}

}
