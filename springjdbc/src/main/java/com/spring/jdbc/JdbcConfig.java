package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan("com.spring.jdbc.dao")
public class JdbcConfig {

	// Declearing required bean methods...

	@Bean("ds")
	DataSource createDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:mysql://localhost:3306/spring_jdbc");

		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		ds.setUsername("root");
		ds.setPassword("Mysql@1234");

		return ds;
	}

	@Bean("jdbcTemplate")
	JdbcTemplate createJdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(createDataSource());

		// jdbcTemplate.setDataSource(createDataSource());

		return jdbcTemplate;
	}

// Instead use Autowiring...

//	@Bean("studentImpl")
//	StudentDao createStudentDaoImpl() {
//		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//		
//		studentDaoImpl.setJdbcTemplate(createJdbcTemplate());
//		
//		return studentDaoImpl;
//	}
}
