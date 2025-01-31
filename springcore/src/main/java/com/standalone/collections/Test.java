package com.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/standalone/collections/config.xml");
		Person p1 = context.getBean("person", Person.class);
		System.out.println(p1.getFriends().getClass().getName());
		System.out.println(p1.getFriends());
		System.out.println(p1.getCourse());
		System.out.println(p1.getProps());
	}

}
