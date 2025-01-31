package com.spring_core.lifecycle;

// Implementing LIFE CYCLE methods of bean using XML configurations
public class Milk {
	
	private double price;
	
	// If default-Constructor is not provided then this will throw Exception(BeanCreationException)
	public Milk() {
		super();
		System.out.println("In default-Constructor Milk");	
	}
	
	@Override
	public String toString() {
		return "Milk [price=" + price + "]";
	}

	public Milk(double price) {
		this.price = price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	// Life cycle methods of bean we can change the name accordingly.
	
	public void init() {
		System.out.println("Inside Init method...");
		// here do required initializations (Database connection)
	}
	
	public void destroy() {
		System.out.println("Inside destroy method...");
		// bean is destroyed here.
	}
}
