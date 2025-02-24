package com.tech.blog.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet method LoginServlet");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<head>");
		out.println("<title>Servlet_1</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h2>LoginServlet Running</h2>");
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		try {
			UserDao ud = new UserDao(ConnectionProvider.createConnection());
			User u = ud.getUserByEmailAndPassword(userEmail, userPassword);
			HttpSession s = request.getSession();
			if(u != null) {
				
				s.setAttribute("currentUser",u);
				response.sendRedirect("profile.jsp");
			}else {
				Message mes = new Message("Invalid datails !!! Please try another way", "error", "alert-danger");
				s.setAttribute("message", mes);
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
		doGet(request, response);
	}

}
