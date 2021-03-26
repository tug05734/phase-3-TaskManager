package com.example.TaskManger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String showRegistration() {
		return "registration";
	}
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/displaytasks")
	public String showDisplaytasks() {
		return "displaytasks";
	}
	
	@GetMapping("/createtask")
	public String showCreatetask() {
		return "createtask";
	}
	
	@GetMapping("/deletetask")
	public String showDeletetask() {
		return "deletetask";
	}
	
	@GetMapping("/updatetask")
	public String showUpdatetask() {
		return "updatetask";
	}
}
