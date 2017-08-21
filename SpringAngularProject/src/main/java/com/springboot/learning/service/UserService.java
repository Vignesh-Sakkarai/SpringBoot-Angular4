package com.springboot.learning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.learning.model.User;

@Service
public interface UserService {

	List<User> getAllUsers();
	
	User getUser(Integer userId);
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Integer userId);
}
