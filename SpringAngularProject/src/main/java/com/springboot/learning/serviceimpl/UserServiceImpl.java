package com.springboot.learning.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.learning.model.User;
import com.springboot.learning.repository.UserRepository;
import com.springboot.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		Iterator<User> iterator = userRepository.findAll().iterator();
		while (iterator.hasNext()) {
			users.add(iterator.next());
		}

		return users;
	}

	@Override
	public User getUser(Integer userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.delete(userId);
	}

}
