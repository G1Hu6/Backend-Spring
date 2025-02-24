package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tech.blog.entities.User;

public class UserDao {
	
	private Connection con;
	
	public UserDao(Connection con){
		this.con = con;
	}
	
	// Insert data into database
	public boolean insertUser(User user){
		boolean flag = false;
		String query = "insert into register(user_name, user_email, user_password, user_gender, user_about) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pt = con.prepareStatement(query);
			
			pt.setString(1, user.getName());
			pt.setString(2, user.getEmail());
			pt.setString(3, user.getPassword());
			pt.setString(4, user.getGender());
			pt.setString(5, user.getAbout());
			
			pt.executeUpdate();
			
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	// Get User with help of email and password
	@SuppressWarnings("null")
	public User getUserByEmailAndPassword(String email, String password) throws SQLException{
		
		User user = null;
		
		String query = "select * from register where user_email = ? and user_password = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			user = new User();
			
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("user_email"));
			user.setPassword(rs.getString("user_password"));
			user.setGender(rs.getString("user_gender"));
			user.setAbout(rs.getString("user_about"));
			user.setId(rs.getInt("user_id"));
			user.setTime(rs.getTimestamp("register_time"));
			user.setProfile(rs.getString("user_profile"));
		}
		return user;
		
	}

	// Update User data to database
	public boolean updateUser(User user) {
		boolean flag = false;
		
		try {
			
			String query = "update register set user_name = ?, user_email = ?, user_password = ?, user_about = ?, user_profile = ? where user_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAbout());
			ps.setString(5, user.getProfile());
			ps.setInt(6, user.getId());
			
			ps.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return flag;
	}
	
	// Get user with help of user_id
	public User getUserByUserId(int userId) {
		User user = new User();
		
		try {
			
			String query = "select * from register where user_id = ?";
			PreparedStatement ps = this.con.prepareStatement(query);
			
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				user.setGender(rs.getString("user_gender"));
				user.setAbout(rs.getString("user_about"));
				user.setId(rs.getInt("user_id"));
				user.setTime(rs.getTimestamp("register_time"));
				user.setProfile(rs.getString("user_profile"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
