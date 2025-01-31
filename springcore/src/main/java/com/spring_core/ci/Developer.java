package com.spring_core.ci;

public class Developer {
	
	private String type;
	
	public Developer(String type) {
		System.out.println("In Developer constructor");
		this.type = type;
	}

	@Override
	public String toString() {
		return "Developer [type=" + type + "]";
	}

}
