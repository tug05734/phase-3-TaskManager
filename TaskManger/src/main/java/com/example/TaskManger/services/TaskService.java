package com.example.TaskManger.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManger.entities.Task;
import com.example.TaskManger.entities.User;
import com.example.TaskManger.repositories.TaskRepository;


@Service
public class TaskService {
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Iterable<Task> GetAllTasks() {
	
		return taskRepository.findAll();
	}

	public Optional<Task> GetTaskById(Integer taskId) {
		
		//TODO: create exception for task not found.
		return taskRepository.findById(taskId);
	}
	
	public Iterable<Task> GetTasksByUser(User user) {
		//TODO: what do we do if the user doesn't have any tasks or doesn't exist?
		
		return(taskRepository.findAllByUser(user.getId()));
	}
	
	public void addNewTask(Task task) {
		taskRepository.save(task);
	}
	
	public void deleteTask(int id) {
		taskRepository.deleteById(id);
	}
	
	public void updateTask(Task task) {
		taskRepository.save(task);
	}
}
