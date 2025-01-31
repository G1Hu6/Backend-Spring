package com.spring_core.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*@org.springframework.stereotype.Component annotation is used to declear bean without xml*/

@Component("pranav")
public class Student{
	
	@Value("Pranav")
	private String name;
	
	@Value("22")
	private int age;
	
	@Value("#{locations}")
	private List<String> locations;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}
}
