package com.allSales.service;

import org.springframework.stereotype.Component;

import com.allSales.domain.User;

@Component
public interface UserService {
	
	void save(User user);
	User findUserByEmail(String email);
	void updateUser(User user);
	User findOne(Long userId);

}
