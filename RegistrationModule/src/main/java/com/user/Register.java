package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@MultipartConfig
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
//			out.println("<!DOCTYPE html>");
//			out.println("<head>");
//			out.println("<title>Servlet_1</title>");
//			out.println("</head>");
//			out.println("<body>");
			String name = req.getParameter("user_name");
			String email = req.getParameter("user_email");
			String password = req.getParameter("user_password");
			//out.println(name + " : " + email + " : "  + password);
			Part part = req.getPart("image");
			String fileName = part.getSubmittedFileName();
			//out.println(fileName);
			
			try {
				
				Thread.sleep(3000);
				
				// connect to database
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_jdbc", "root", "Mysql@1234");
				
				// add values in table
				String query = "insert into registration(user_name, user_password, user_email, image_name) values(?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.setString(4, fileName);
				
				ps.executeUpdate();
				
				// Uploading data to folder
				InputStream is = part.getInputStream();
				
				byte[] data = new byte[is.available()];
				is.read(data);
				
				String path = "C:\\Users\\prana\\jsp-servlet1\\RegistrationModule\\src\\main\\webapp\\" + "images" + File.separator + fileName;
				//out.println(path);
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(data);
				fos.close();
				
				out.println("Done");	// responce
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
//			out.println("</body>");
//			out.println("</html>");
	}
}