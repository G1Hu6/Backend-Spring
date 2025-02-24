package com.tech.blog.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection con;
	
	public static Connection createConnection() throws SQLException, ClassNotFoundException{
		if(con == null) {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog", "root", "Mysql@1234");
		}
		
		return con;
	}
}
