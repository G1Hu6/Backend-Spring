package com.spring_core.ref;

public class Address {
	private String location;
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Address [location=" + location + "]";
	}

	public String getLocation() {
		return location;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(String location) {
		this.location = location;
	}
}
