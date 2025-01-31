package com.spring_core.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependancies {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/ci/ciconfig.xml");
		
		A a = context.getBean("classA", A.class);
		B b = context.getBean("classB", B.class);
		System.out.println(b);
		System.out.println(a);
		
		/*
		 Circular dependencies :-
         If you use predominantly constructor injection, it is possible to create an unresolvable 
         circular dependency scenario.

		 For example: Class A requires an instance of class B through constructor injection, and 
		 class B requires an instance of class A through constructor injection. If you configure 
		 beans for classes A and B to be injected into each other, the Spring IoC container detects 
		 this circular reference at runtime, and throws a BeanCurrentlyInCreationException.
		 
		 Output :-
		 Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'classA': Requested bean is currently in creation: Is there an unresolvable circular reference?
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.beforeSingletonCreation(DefaultSingletonBeanRegistry.java:355)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:227)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199)
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveReference(BeanDefinitionValueResolver.java:365)
	... 29 more
		  
		 */
	}
}
