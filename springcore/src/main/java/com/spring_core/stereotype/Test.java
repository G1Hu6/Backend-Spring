package com.spring_core.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/stereotype/config.xml");
		Student student = context.getBean("pranav", Student.class);
		System.out.println(student);
		System.out.println(student.getLocations());
		System.out.println(student.getLocations().getClass().getName());
	}

}
