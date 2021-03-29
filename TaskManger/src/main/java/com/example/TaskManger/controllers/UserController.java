package com.example.TaskManger.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
			if(user != null) {
				if(user.getPassword().equals(password)) {
					model.addAttribute("userName", user.getName());
					model.addAttribute("userEmail", user.getEmail());
					model.addAttribute("userPassword", user.getPassword());
					return "home";
				}else {
					model.addAttribute("errorMessage", "Entered E-mail or Password was incorrect");
				}
			}else {
				model.addAttribute("errorMessage", "User not found!");
			}
		}else {
			model.addAttribute("errorMessage","You must enter both E-mail and Password");
		}
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		user = null;
		return "index";
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
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(HttpServletRequest request, MissingServletRequestParameterException ex) {
	    String name = ex.getParameterName();
	    System.out.println(name + " parameter is missing");
	    ModelAndView mav = new ModelAndView("failure");
	    mav.addObject("exceptionError", "Start date and/or end date fields are missing");
	    // Actual exception handling
	    //model.addAttribute("exceptionError", "Start date and/or end date fields are missing");
	    return mav;
	    
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullUser(HttpServletRequest request, NullPointerException ex) {
		
		String name = ex.getLocalizedMessage();
	    System.out.println(name);
		ModelAndView mav = new ModelAndView("failure");
		mav.addObject("exceptionError", name  + ". <br><br>If user is null please <a href='/login'>login</a> again.");
		
		return mav;
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView handleDataNotFound(HttpServletRequest request, EmptyResultDataAccessException ex) {
		
		String name = ex.getLocalizedMessage();
	    System.out.println(name);
		ModelAndView mav = new ModelAndView("failure");
		mav.addObject("exceptionError", name  + ". <br><br>You must enter a valid task ID!");
		
		return mav;
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleDataNotFound(HttpServletRequest request, NumberFormatException ex) {
		
		String name = ex.getLocalizedMessage();
	    System.out.println(name);
		ModelAndView mav = new ModelAndView("failure");
		mav.addObject("exceptionError", name  + ". <br><br>Invalid input for a field. Make sure no letters are present in fields that require numerical input");
		
		return mav;
	}
}
