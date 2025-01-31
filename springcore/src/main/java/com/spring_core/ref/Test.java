package com.spring_core.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/ref/refconfig.xml");
		Student student = context.getBean("student", Student.class);
		Student student2 = context.getBean("student2", Student.class);
		System.out.println(student);
		System.out.println(student2);
	}

}
