package com.spring_core.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;

// We can use @Bean annotation instead of @Component to create and declear bean. 

public class Parent {
	
	private Child child;
	
	public Child getChild() {
		return child;
	}

	public Parent(Child child) {
		super();
		this.child = child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	
    public void marry() {
    	this.child.property();
    	System.out.println("Marry with Bhabhi-2");
    }
}
