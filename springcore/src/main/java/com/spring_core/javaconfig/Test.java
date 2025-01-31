package com.spring_core.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Test {
	
	// 1.Simple Construction
	public static void main(String[] args) {
		
		/*
		XML based configuration
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/javaconfig/config.xml");
		*/
		
		// Java based annotation-configuration
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
		Parent parent = context.getBean("getParent", Parent.class);
		System.out.println(parent);
		parent.marry();
	}

}
