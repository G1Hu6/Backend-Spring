package com.spring_core.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/lifecycle/lifeconfig.xml");
		//Milk milk = (Milk)context.getBean("milk");
		//System.out.println(milk);
		
		// To call destroy method of bean we have to call registerShutdownHook() method of AbstractApplicationContext
		AbstractApplicationContext con = new ClassPathXmlApplicationContext("com/spring_core/lifecycle/lifeconfig.xml");
		//Milk milk = (Milk)con.getBean("milk");
		//System.out.println("Bean Runtime Type = " + con.getType("milk"));
		con.registerShutdownHook();
		//System.out.println(milk);
		
		//Teacher t = (Teacher)con.getBean("teacher");
		//System.out.println(t);
		
		Subject sub = con.getBean("subject", Subject.class);
		System.out.println(sub);
	}

}
