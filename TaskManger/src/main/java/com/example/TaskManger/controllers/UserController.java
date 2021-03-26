package com.example.TaskManger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManger.entities.User;
import com.example.TaskManger.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String showForm(ModelMap model) {
		return "login";
	}
	
	@PostMapping("/login")
	public String checkAuthentication(ModelMap model, @RequestParam("email") String email, @RequestParam("password") String password) {
		
		if(!email.isBlank() && !password.isBlank()) {
			User user = userService.getUserByEmail(email);
			if(user.getPassword().equals(password)) {
				model.addAttribute("user", user.getName());
				return "home";
			}else {
				model.addAttribute("errorMessage", "Entered E-mail or Password was incorrect");
			}
		}else {
			model.addAttribute("errorMessage","You must enter both E-mail and Password");
		}
		
		return "login";
	}
	
}
