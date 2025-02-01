package com.mvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String roll;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String email, String password, String roll) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roll = roll;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", roll=" + roll + "]";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoll() {
		
		return roll;
	}
	
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
	

}
