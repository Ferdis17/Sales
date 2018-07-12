package com.allSales.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.allSales.domain.Role;
import com.allSales.domain.User;
import com.allSales.repository.RoleRepository;
import com.allSales.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findRoleByRoleName("ADMIN");
		user.setRoles(new ArrayList<>(Arrays.asList(userRole)));
		userRepository.save(user);
		
	}

	@Override
	public User findUserByEmail(String email) {
		
		return userRepository.findUsersByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User findOne(Long userId) {
		
		return userRepository.findOne(userId);
	}

}
