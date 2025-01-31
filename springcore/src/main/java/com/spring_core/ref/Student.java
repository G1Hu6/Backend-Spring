package com.spring_core.ref;

public class Student {
	
	private String name;
	
	/// Class Student is dependent on class Address
	private Address address; 
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + "]";
	}

	public Student() {
		super();
	}
	
	public Student(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
