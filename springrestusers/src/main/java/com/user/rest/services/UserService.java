package com.user.rest.services;

import java.util.List;

import com.user.rest.entities.User;


public interface UserService {

	public List<User> getUsers();
	
	public User getUser(long userId);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(long userId);
}
