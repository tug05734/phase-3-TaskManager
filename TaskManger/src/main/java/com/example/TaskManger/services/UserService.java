package com.example.TaskManger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManger.entities.User;
import com.example.TaskManger.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	public void registerUser(User user) {
		userRepository.save(user);
	}
}