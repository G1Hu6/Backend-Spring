package com.spring_core.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/ci/ciconfig.xml");
		//Person p1 = context.getBean("person1", Person.class);
		//Person p2 = context.getBean("person2", Person.class);
		//System.out.println(p1);
		//System.out.println(p2);
		
		Addition add = context.getBean("add", Addition.class);
		add.doSum();
	}
}
