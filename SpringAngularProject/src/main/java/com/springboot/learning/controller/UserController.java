package com.springboot.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learning.model.User;
import com.springboot.learning.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	@ResponseBody
	public String hi() {
		return "HHHHHHHHHHHHHHHHHHHHHHHHHHHHH";
	}
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("userId") Integer userId) {
		return userService.getUser(userId);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	@ResponseBody
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
	}
		
}
