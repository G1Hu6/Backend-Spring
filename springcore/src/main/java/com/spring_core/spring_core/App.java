package com.spring_core.spring_core;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext();
        Student s1 = (Student)context.getBean("student1");
        Student s2 = context.getBean("student2",Student.class);
        Student s3 = context.getBean("student3",Student.class);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
