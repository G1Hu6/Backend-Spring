package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeDao {
	
	private Connection con;
	
	public LikeDao(Connection con) {
		
			this.con = con;
	}
	
	// insert Like into likes table
	public boolean insertLike(int pId, int uId) {
		
		boolean isLiked = false;
		
		try {
			
			String query = "insert into likes(u_id, p_id) values(?, ?)";
			PreparedStatement ps = this.con.prepareStatement(query);
			
			ps.setInt(1, uId);
			ps.setInt(2, pId);
			
			ps.executeUpdate();
			
			isLiked = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isLiked;
	}
	
	// count total likes on post
	public int countLikesonPost(int pId) {
		
		int likeCount = 0;
		
		try {
			
			String query = "select count(*) from likes where p_id = ?";
			PreparedStatement ps = this.con.prepareStatement(query);
			
			ps.setInt(1, pId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				likeCount = rs.getInt("count(*)");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return likeCount;
	}
	
	// function is to check that post is liked by user or not
	public boolean isLikedByUser(int pId, int uId) {
		boolean isLiked = false;
		
		try {
			
			String query = "select * from likes where u_id = ? and p_id = ?";
			PreparedStatement ps = this.con.prepareStatement(query);
			
			ps.setInt(1, uId);
			ps.setInt(2, pId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				isLiked = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isLiked;
	}
	
	// delete like(dislike)
	public boolean deleteLike(int pId, int uId) {
		
		boolean isDeleted = false;
		
		try {
			
			String query = "delete from likes where u_id = ? and p_id = ?";
			PreparedStatement ps = this.con.prepareStatement(query);
			
			ps.setInt(1, uId);
			ps.setInt(2, pId);
			
			ps.executeUpdate();
			
			isDeleted = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}
}
