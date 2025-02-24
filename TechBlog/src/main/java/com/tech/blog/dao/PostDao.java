package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;

public class PostDao {
	
	private Connection con;
	
	public PostDao(Connection con) {
		
		this.con = con;
	}
	
	public ArrayList<Category> getAllCategories(){
		ArrayList<Category> catList = new ArrayList<Category>();
		
		try {
			
			String query = "select * from categorys";
			Statement st = this.con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				int cId = rs.getInt("c_id");
				String cName = rs.getString("c_name");
				String cDescription = rs.getString("c_description");
				Category c = new Category(cId,cName,cDescription);
				catList.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return catList;
	}
	
	// Insert Blog-post into database
	public boolean insertPost(Post post) {
		boolean flag = false;
		
		try {
			
			String query = "insert into posts(post_title, post_content, post_code, post_image,cat_id, user_id) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, post.getpTitle());
			ps.setString(2, post.getpContent());
			ps.setString(3, post.getpCode());
			ps.setString(4, post.getpImage());
			ps.setInt(5, post.getCatId());
			ps.setInt(6, post.getUserId());
			
			ps.executeUpdate();
			
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	// getting all posts from database
	public ArrayList<Post> getAllPosts(){
		
		ArrayList<Post> pList = new ArrayList<Post>();
		
		try {
			
			PreparedStatement ps  = this.con.prepareStatement("select * from posts order by post_id desc");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int pId = rs.getInt(1);
				String pTitle = rs.getString(2);
				String pContent = rs.getString(3);
				String pCode = rs.getString(4);
				String pImage = rs.getString(5);
				Timestamp pDate = rs.getTimestamp(6);
				int catId = rs.getInt(7);
				int userId = rs.getInt(8);
				
				Post post = new Post(pId,pTitle, pContent, pCode, pImage, pDate, catId, userId);
				pList.add(post);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pList;
	}
	
	// getting posts from database for specific Category
		public ArrayList<Post> getPostsByCategory(int catId){
			ArrayList<Post> pListByCat = new ArrayList<Post>();
			try {
				
				PreparedStatement ps  = this.con.prepareStatement("select * from posts where cat_id = ?");
				ps.setInt(1, catId);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					int pId = rs.getInt(1);
					String pTitle = rs.getString(2);
					String pContent = rs.getString(3);
					String pCode = rs.getString(4);
					String pImage = rs.getString(5);
					Timestamp pDate = rs.getTimestamp(6);
					int userId = rs.getInt(8);
					
					Post post = new Post(pId,pTitle, pContent, pCode, pImage, pDate, catId, userId);
					pListByCat.add(post);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return pListByCat;
		}
		
		// getting posts from database by postId
		public Post getPostsByPostId(int postId) {
			Post post = null;
			
			try {
				
				String query = "select * from posts where post_id = ?";
				PreparedStatement ps = this.con.prepareStatement(query);
				
				ps.setInt(1, postId);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int pId = rs.getInt(1);
					String pTitle = rs.getString(2);
					String pContent = rs.getString(3);
					String pCode = rs.getString(4);
					String pImage = rs.getString(5);
					Timestamp pDate = rs.getTimestamp(6);
					int catId = rs.getInt(7);
					int userId = rs.getInt(8);
					
					post = new Post(pId, pTitle, pContent, pCode, pImage, pDate, catId, userId);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
			return post;
		}
}
