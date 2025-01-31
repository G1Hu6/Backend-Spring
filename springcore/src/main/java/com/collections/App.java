package com.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {
	public static void main(String[] args) {
		System.out.println("Collection Demo");
		ApplicationContext context = new ClassPathXmlApplicationContext("empconfig.xml");
		Employee emp1 = context.getBean("emp1",Employee.class);
		System.out.println(emp1.getEmpName());
		System.out.println(emp1.getEmpPhoneNo());
		System.out.println(emp1.getEmpLocations());
		System.out.println(emp1.getProps());
		System.out.println(emp1.getEmpInfo());
	}
}
