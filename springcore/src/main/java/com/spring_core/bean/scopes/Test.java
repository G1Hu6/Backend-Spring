package com.spring_core.bean.scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/bean/scopes/config.xml");
		
		// ------- 1. Using Annotations -------- //
		Student student1 = context.getBean("student", Student.class);
		// Printing hashcode to chek object is modified or not
		System.out.println(student1.hashCode());
		
		Student student2 = context.getBean("student", Student.class);
		Student student3 = new Student();
		System.out.println(student2.hashCode());
		System.out.println(student3.hashCode());
		// If scope of bean is singleton(by default if not provided) then both objects are having same hashcode.
		
		
		// ------- 1. Using XML -------- //
		Teacher teacher1 = context.getBean("teacher", Teacher.class);
		System.out.println(teacher1.hashCode());
		
		Teacher teacher2 = context.getBean("teacher", Teacher.class);
		System.out.println(teacher2.hashCode());
		
	}

}
