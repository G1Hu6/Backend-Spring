package com.user.rest.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.rest.dao.UserDao;
import com.user.rest.entities.User;


@Service
public class UserServicesImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserServicesImpl() {
		super();
	}
	
	@Override
	public List<User> getUsers() {
		
		return this.userDao.findAll();
	}

	@Override
	public User getUser(long userId) {
		
		return userDao.getReferenceById(userId);
	}

	@Override
	public User addUser(User user) {
		
		return userDao.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		
		return userDao.save(user);
	}
	
	@Override
	public void deleteUser(long userId){
		
		userDao.delete(userDao.getReferenceById(userId));
	}

	
}
