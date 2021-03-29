package com.example.TaskManger.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManger.entities.Task;
import com.example.TaskManger.entities.User;
import com.example.TaskManger.repositories.TaskRepository;
import com.example.TaskManger.services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController extends UserController {
	
	
	
	@Autowired
	private TaskService taskService;
	Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@GetMapping("/displaytasks")
	public String showDisplaytasks(ModelMap model) {
		Iterable<Task> tasks = taskService.GetTasksByUser(user);
		model.addAttribute("task", tasks);
		return "displaytasks";
	}
	
	@GetMapping("/createtask")
	public String showCreatetask() {
		return "createtask";
	}
	
	@PostMapping("/createtask")
	public String addTask(ModelMap model, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
			@RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate, @RequestParam("severity") String severity, @RequestParam("description") String description) {
		
		if(!name.isBlank() && !email.isBlank() && startDate != null && !endDate.toString().isBlank() && !severity.isBlank()) {
			Task task = new Task();
			task.setName(name);
			task.setEmail(email);
			task.setDescription(description);
			task.setStartDate(startDate);
			task.setEndDate(endDate);
			task.setSeverity(severity);
			task.setUserId(user);
			taskService.addNewTask(task);
			return "success";
		}else {
			model.addAttribute("errorMessage", "Must enter all fields");
		}
		
		return "createtask";
	}
	
	@GetMapping("/deletetask")
	public String showDeletetask(ModelMap model) {
		Iterable<Task> tasks = taskService.GetTasksByUser(user);
		model.addAttribute("task", tasks);
		return "deletetask";
	}
	
	@PostMapping("/deletetask")
	public String deleteTask(ModelMap model, @RequestParam("id") String id) {
		
		if(!id.isBlank()) {
			taskService.deleteTask(Integer.parseInt(id));
			return "success";
		}else {
			model.addAttribute("errorMessage", "Must enter ID");
		}
		
		return "deletetask";
	}
	
	
	@GetMapping("/updatetask")
	public String showUpdatetask(ModelMap model) {
		Iterable<Task> tasks = taskService.GetTasksByUser(user);
		model.addAttribute("task", tasks);
		return "updatetask";
	}
	
	@PostMapping("/updatetask")
	public String updateTask(ModelMap model, @RequestParam("id") String id ,@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
			@RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate, @RequestParam("severity") String severity, @RequestParam("description") String description) {
		
		if(!id.isBlank() && !name.isBlank() && !email.isBlank() && startDate != null && !endDate.toString().isBlank() && !severity.isBlank()) {
			Task task = new Task();
			task.setId(Integer.parseInt(id));
			task.setName(name);
			task.setEmail(email);
			task.setDescription(description);
			task.setStartDate(startDate);
			task.setEndDate(endDate);
			task.setSeverity(severity);
			task.setUserId(user);
			taskService.updateTask(task);
			return "success";
		}else {
			model.addAttribute("errorMessage", "Must enter all fields");
		}
		
		return "updatetask";
	}
	
}
