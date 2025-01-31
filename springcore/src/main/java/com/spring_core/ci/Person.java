package com.spring_core.ci;

import java.util.List;
// Constructor Injection //

public class Person {
	
	private String personName;
	private int personId;
	private Developer devType;
	private List<String> languages;
	
	public Person(String personName,int personId, Developer devType,List<String> languages ) {
		System.out.println("In Person constructor");
		this.personName = personName;
		this.personId = personId;
		this.devType = devType;
		this.languages = languages;
	}
	
	@Override
	public String toString() {
		return this.personName + " : " + this.personId + "[ "+ this.devType+" ]";
	}
}
