package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectDemo{
	public static void main(String[] args) {
		try {
			// connect to database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_jdbc", "root", "Mysql@1234");
			
			// add values in table
			String query = "insert into registration(user_name, user_password, user_email) values(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "Pranav");
			ps.setString(2, "Pass@123");
			ps.setString(3, "hello@gmail.com");
			
			ps.executeUpdate();
			System.out.println("Data is registered in Database...");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
