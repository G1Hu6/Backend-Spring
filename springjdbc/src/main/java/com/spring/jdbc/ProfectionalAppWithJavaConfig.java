package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;

public class ProfectionalAppWithJavaConfig {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(JdbcConfig.class);
		context.refresh();
		StudentDaoImpl studentDao = context.getBean("studentImpl", StudentDaoImpl.class);
		
		/// INSERT
		/*
		Student student = new Student();
		student.setId(106);
		student.setName("Harshal Wande");
		student.setLanguage("NullPointerException");
		studentDao.insert(student);
		System.out.println("INSERT ok!");
		*/
		
		List<Student> students = studentDao.selectAllStudents();
		for(Student s: students) {
			System.out.println(s);
		}
	}
}
