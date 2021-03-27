package com.example.TaskManger.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.TaskManger.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
	
	@Query("SELECT t FROM Task t WHERE t.user.id = ?1")
	public Iterable<Task> findAllByUser(int userId);
	
}
