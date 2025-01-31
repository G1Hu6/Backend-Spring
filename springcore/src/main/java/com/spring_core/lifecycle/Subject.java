package com.spring_core.lifecycle;

// Implementing Bean LifeCyle using Annotations 
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Subject {
	
	private String name;
	
	public Subject() {
		super();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + "]";
	}
	
	@PostConstruct
	public void Start() {
		System.out.println("Starting...");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Ending...");
	}
}
