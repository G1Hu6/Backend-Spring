package com.spring_core.autowire.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/autowire/annotations/auto.xml");
		Employee emp = context.getBean("employee", Employee.class);
		System.out.println(emp);
	}

}
