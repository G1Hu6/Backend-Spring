package com.mvc.models;

import java.util.List;

public class Student {
	
	private String name;
	private long id;
	private String email;
	private String division;
	private List<String> languages;
	private String gender;
	private Address address;
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", email=" + email + ", division=" + division + ", languages="
				+ languages + ", gender=" + gender + ", address=" + address + "]";
	}

	public Student(String name, long id, String email, String division, List<String> languages, String gender,
			Address address) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.division = division;
		this.languages = languages;
		this.gender = gender;
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}

    public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
