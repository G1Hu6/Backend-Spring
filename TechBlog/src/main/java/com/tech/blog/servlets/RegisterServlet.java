package com.tech.blog.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet method RegisterServlet");
		PrintWriter out = response.getWriter();
		
		String check = request.getParameter("check");
		if(check== null) {
			out.println("Please check terms and conditions");
		}else {
			
//			out.println("<!DOCTYPE html>");
//			out.println("<head>");
//			out.println("<title>RegisterServlet</title>");
//			out.println("</head>");
//			out.println("<body>");
	//
//			out.println("<h2>RegisterServlet Running</h2>");
			
			//Fetching data from register.jsp page
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String about = request.getParameter("about");
			
			//create user instance
			User user = new User(name, email, password, gender, about);
			
			//Insert into database
			UserDao ud;
			try {
				ud = new UserDao(ConnectionProvider.createConnection());
				
				if(ud.insertUser(user)) {
					out.println("done");
				}else {
					out.println("Error");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		doGet(request, response);
	}

}
