package com.user.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.rest.entities.User;

/*
 	JpaRepository<EntityClassName, TypeOfIdVariable>
*/
public interface UserDao extends JpaRepository<User, Long>{
	
}
