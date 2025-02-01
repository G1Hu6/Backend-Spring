package com.mvc.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.UserDao;
import com.mvc.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public int createUser(User user) {
		return this.userDao.saveUser(user);
	}
}
