package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;

public class ProfectionalAppWithXML {

	public static void main(String[] args) {
		
		// 2.Profectional Way
		System.out.println( "My Profectional SpringJdbc Program...." );
	    @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/jdbconfig.xml");
	    
	    StudentDao stdDao = context.getBean("studentImpl", StudentDaoImpl.class);
	    
	    
	    /// INSERT
	    // Instantiating Student Object
	    Student student = context.getBean(Student.class);
	    student.setId(104);
	    student.setName("Shryash Sutar");
	    student.setLanguage("Marathi");
	    
	    // 1.Insert into database
	    int rowsAffected = stdDao.insert(student);
	    System.out.println("Query OK, "+ rowsAffected +" row affected");
	     
	    
	    /*
	    /// UPDATE
	    Student student2 = context.getBean(Student.class);
	    student2.setId(101);
	    student2.setName("Ganesh");
	    student2.setLanguage("C");
	 
	    
	    // 2.Update values in database
	    int result = stdDao.update(student2);
	    System.out.println("Query UPDATE, "+ result +" row affected");

	    
	    /// DELETE
	    System.out.println("ENTER ID : ");
	    Scanner sc = new Scanner(System.in);
	    int result = stdDao.delete(sc.nextInt());
	    System.out.println("Query DELETE, "+ result +" row affected");
	   
	    
	    /// SELECT (RowMapper)
	    Student student3 = stdDao.selectedStudent(101);
	    System.out.println(student3);
	    */
	    
	    List<Student> students = stdDao.selectAllStudents();
	    for(Student s:students) {
	    	System.out.println(s);
	    }
	}

}
