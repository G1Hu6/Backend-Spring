package com.user.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.rest.entities.User;
import com.user.rest.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userServices;
	
	// These is testing method to check
	@GetMapping("/home")
	public String home() {
		
		return "These is Home page";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return userServices.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable String userId) {
		
		return userServices.getUser(Long.parseLong(userId));
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userServices.addUser(user);
	}
	
	@PutMapping("/update/users")
	public User updateUser(@RequestBody User user) {
		return userServices.updateUser(user);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
		try {
			userServices.deleteUser(Long.parseLong(userId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
