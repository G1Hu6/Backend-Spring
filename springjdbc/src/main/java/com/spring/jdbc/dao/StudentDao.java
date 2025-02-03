package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entity.Student;

// StudentDao interface for accessing database
public interface StudentDao {
	
	public int insert(Student student);
	
	public int update(Student student);
	
	public int delete(int id);
	
	public Student selectedStudent(int id);
	
	public List<Student> selectAllStudents();
}
