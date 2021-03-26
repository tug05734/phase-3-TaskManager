package com.example.TaskManger.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.TaskManger.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findUserByEmail(String email);
	
}
