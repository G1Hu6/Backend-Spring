package com.spring_core.lifecycle;

import org.springframework.beans.factory.InitializingBean;
// InitializingBean is used to override init() method
import org.springframework.beans.factory.DisposableBean;

// Implementing bean life cycle using interfaces 

public class Teacher implements InitializingBean, DisposableBean{
	
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [subject=" + subject + "]";
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void afterPropertiesSet() {
		// init method
		System.out.println("Init method of Teacher...");
	}
	
	@Override
	public void destroy() {
		// destroy method
		System.out.println("Destroy method of Teacher...");
	}
	
}
