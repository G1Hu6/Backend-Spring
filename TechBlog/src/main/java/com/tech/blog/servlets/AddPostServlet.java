package com.tech.blog.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Post;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class AddPostServlet
 */
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int cId = Integer.parseInt(request.getParameter("cid")); 
		String pTitle = request.getParameter("title"); 
		String pContent = request.getParameter("content");
		String pCode = request.getParameter("code");
		Part part = request.getPart("image");
		
		HttpSession s = request.getSession();
		User user = (User)s.getAttribute("currentUser");
		
		Post post = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(),null,cId,user.getId());
		
		PostDao pd;
		try {
			pd = new PostDao(ConnectionProvider.createConnection());
			
			if(pd.insertPost(post)) {
				
				String postPath =  "C:\\Users\\prana\\jsp-servlet1\\TechBlog\\src\\main\\webapp\\" + "post_pics"
						+ File.separator + part.getSubmittedFileName();
				if(Helper.saveFile(part.getInputStream(), postPath)) {
					
					out.println("done");
				}else {
					
					out.println("image cannot saved !!!");
				}
			}else {
				out.println("error");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
