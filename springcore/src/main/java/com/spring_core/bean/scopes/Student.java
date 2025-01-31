package com.spring_core.bean.scopes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//------- 1. Using Annotations -------- //

@Component
@Scope("prototype")
public class Student {
	
	@Value("Pranav")
	private String name;
	
	@Value("101")
	private int id;
	
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
