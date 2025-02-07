//package com.user.rest.services;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.stereotype.Service;
//
//
//import com.user.rest.entities.User;
//
//@Service
//public class TryServices implements UserService{
//
//	private List<User> allUsers;
//	
//	public TryServices() {
//	     allUsers = new ArrayList<User>();
//	     allUsers.add(new User(1,"Pranav Patil","photo1", 1000,"hiii hello bhaii"));
//	     allUsers.add(new User(2, "Tejas Tathe", "photo2", 20000, "Sayli Thopte one L0v9"));
//	}
//	
//	@Override
//	public List<User> getUsers() {
//		
//		return this.allUsers;
//	}
//
//	@Override
//	public User getUser(long userId) {
//		User user = null;
//		for(User u : this.allUsers) {
//			
//			if(u.getUserId() == userId) {
//				user = u;
//				break;
//			}
//		}
//		return user;
//	}
//
//	@Override
//	public User addUser(User user) {
//		this.allUsers.add(user);
//		return user;
//	}
//	
//	@Override
//	public void deleteUser(long user){
//		
//	}
//
//	@Override
//	public User updateUser(User user) {
//		
//		return null;
//	}
//}
