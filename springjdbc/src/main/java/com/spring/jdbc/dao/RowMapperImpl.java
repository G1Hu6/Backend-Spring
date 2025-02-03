package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

public class RowMapperImpl implements RowMapper<Student>{
	@Override
	public Student mapRow(ResultSet rs, int rowNum)throws SQLException{
		Student student = new Student();
		
		student.setId(rs.getInt("student_id"));
		student.setName(rs.getString("student_name"));
		student.setLanguage(rs.getString(3));
		
		return student;
	}
}
