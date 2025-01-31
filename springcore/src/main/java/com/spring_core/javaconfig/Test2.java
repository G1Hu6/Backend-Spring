package com.spring_core.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


//  2. Building the Container Programmatically by Using register(Class<?>…​)

public class Test2 {
    
	public static void main(String[] args) {
		
//		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
//		Parent p = context.getBean(Parent.class);
//		p.marry();
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		System.out.println("Registering configuration class");
		context.register(JavaConfiguration.class);  // registering configuration class programmatically by Using register(Class<?>…​)
		context.refresh();
		Parent p = context.getBean(Parent.class);
		p.marry();
	}
}
