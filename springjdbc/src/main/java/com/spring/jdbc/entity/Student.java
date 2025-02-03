package com.spring.jdbc.entity;

public class Student {
	
	private int id;
	private String name;
	private String language;
	
	public Student(int id, String name, String language) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", language=" + language + "]";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}

}
