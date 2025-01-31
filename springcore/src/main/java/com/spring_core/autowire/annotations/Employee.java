package com.spring_core.autowire.annotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
public class Employee {
	
	

	private Address address;
	private String name;

	
	public Employee(Address address, String name) {
		super();
		System.out.println("Constructor ...");
		this.address = address;
		this.name = name;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address getAddress() {
		return address;
	}
	
	@Autowired
	@Qualifier("address2")  //by name
	public void setAddress(Address address) {
		System.out.println("Setting Value ...");
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "Employee [address=" + address + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
