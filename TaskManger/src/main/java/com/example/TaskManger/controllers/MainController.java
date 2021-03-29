package com.example.TaskManger.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.TaskManger.entities.User;

@Controller
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
//	@GetMapping("/login")
//	public String showLogin() {
//		return "login";
//	}
	
//	@GetMapping("/registration")
//	public String showRegistration() {
//		return "registration";
//	}
	
	@GetMapping("/home")
	public String showHome(ModelMap model) {
		return "home";
	}
	
//	@GetMapping("/displaytasks")
//	public String showDisplaytasks() {
//		return "displaytasks";
//	}
//	
//	@GetMapping("/createtask")
//	public String showCreatetask() {
//		return "createtask";
//	}
//	
//	@GetMapping("/deletetask")
//	public String showDeletetask() {
//		return "deletetask";
//	}
//	
//	@GetMapping("/updatetask")
//	public String showUpdatetask() {
//		return "updatetask";
//	}
}
