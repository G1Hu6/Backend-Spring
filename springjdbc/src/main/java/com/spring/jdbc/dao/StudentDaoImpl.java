package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("studentImpl")
public class StudentDaoImpl implements StudentDao{
	

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		int rowsAffected = 0;
		String query = "insert into student(student_id, student_name, student_lang) values(?, ?, ?)";
		
		// Inserting data into database using update method
		rowsAffected = this.jdbcTemplate.update(query,student.getId(), student.getName(), student.getLanguage());
		
		return rowsAffected;
	}


	@Override
	public int update(Student student) {
		int rowsAffected = 0;
		
		String query = "update student set student_name = ?, student_lang = ? where student_id = ?";
		
		// Updating data in database using update method
		rowsAffected = this.jdbcTemplate.update(query, student.getName(), student.getLanguage(), student.getId());
		return rowsAffected;
	}

	@Override
	public int delete(int id) {
		
		String query = "delete from student where student_id = ?";
		
		int rowsAffected = this.jdbcTemplate.update(query,id);
		
		return rowsAffected;
	}

	@Override
	public Student selectedStudent(int id) {
		Student student = new Student();
		
		String query = "select * from student where student_id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		student = this.jdbcTemplate.queryForObject(query, rowMapper, id);
		return student;
	}
	
	@Override
	public List<Student> selectAllStudents() {
		String query = "select * from student";
		
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("Inside Setter JdbcTemplate");
		this.jdbcTemplate = jdbcTemplate;
	}

}
