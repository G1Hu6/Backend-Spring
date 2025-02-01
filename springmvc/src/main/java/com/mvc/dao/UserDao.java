package com.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.models.User;

@Repository
public class UserDao {
	
	@Autowired
	private HibernateTemplate hiberTemp;
	
	public int saveUser(User user) {
		Integer id = (Integer) hiberTemp.save(user);
		return id;
	}
}
