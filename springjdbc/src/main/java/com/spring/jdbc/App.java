package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	// 1.Normal Way(Not-Profectional)
    	
        System.out.println( "My SpringJdbc Program...." );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/jdbconfig.xml");
        
        // creating Instance of JdbcTemplate class
        JdbcTemplate jdbcTemp = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        String query = "insert into student(student_id, student_name, student_lang) values(?, ?, ?)";
        // Inserting data into database using update method
        int rowsAffected = jdbcTemp.update(query,102,"Tejas Tathe", "Python");
        System.out.println("Query OK, "+ rowsAffected +" row affected");
        
    }
}
