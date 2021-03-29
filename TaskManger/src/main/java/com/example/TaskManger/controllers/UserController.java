package com.example.TaskManger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManger.entities.User;
import com.example.TaskManger.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	protected static User user;
	
	@GetMapping("/login")
	public String showForm(ModelMap model) {
		return "login";
	}
	
	@PostMapping("/login")
	public String checkAuthentication(ModelMap model, @RequestParam("email") String email, @RequestParam("password") String password) {
		
		if(!email.isBlank() && !password.isBlank()) {
			user = userService.getUserByEmail(email);
			if(user.getPassword().equals(password)) {
				model.addAttribute("userName", user.getName());
				model.addAttribute("userEmail", user.getEmail());
				model.addAttribute("userPassword", user.getPassword());
				return "home";
			}else {
				model.addAttribute("errorMessage", "Entered E-mail or Password was incorrect");
			}
		}else {
			model.addAttribute("errorMessage","You must enter both E-mail and Password");
		}
		
		return "login";
	}
	
	@GetMapping("/registration")
	public String showRegistration() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registerUser(ModelMap model, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("password1") String password1) throws InterruptedException {
		
		if(name.isBlank() || email.isBlank() || password.isBlank() || password1.isBlank()) {
			model.addAttribute("errorMessage", "Please enter all fields");
			return "registration";
		}else {
			if(!password.equals(password1)) {
				model.addAttribute("errorMessage", "Passwords do not match!");
				return "registration";
			}else {
				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				userService.registerUser(user);
				model.addAttribute("message", "Congratulations, you're account has been registered!");
				return "login";
			}
		}
	}
	
	
}
