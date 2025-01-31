package com.spring_core.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.spring_core.javaconfig")
public class JavaConfiguration {
	
	@Bean
	public Child getProperty() {
		return new Child();
	}
	
	@Bean
	public Parent getParent() {
		
		// Here we create a new parent object
		// the name attribute of bean is same as method name which is used to create bean. (getParent in this case)
		Parent parent = new Parent(getProperty());
		return parent;
	}
}
