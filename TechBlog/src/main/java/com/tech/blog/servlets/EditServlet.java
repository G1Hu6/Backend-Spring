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

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class EditServlet
 */

@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");

		String newName = request.getParameter("new_name");
		String newEmail = request.getParameter("new_email");
		String newPassword = request.getParameter("new_password");
		String newAbout = request.getParameter("new_about");

		Part part = request.getPart("new_profile");
		String newProfileName = part.getSubmittedFileName();

		// Updating new values to user object from session
		user.setName(newName);
		user.setEmail(newEmail);
		user.setPassword(newPassword);
		user.setAbout(newAbout);

		String oldProfile = user.getProfile();
		user.setProfile(newProfileName);

		try {
			UserDao ud = new UserDao(ConnectionProvider.createConnection());

			if (ud.updateUser(user)) {
				out.println("<h4>Done</h4>");

				String newPath = "C:\\Users\\prana\\jsp-servlet1\\TechBlog\\src\\main\\webapp\\" + "pics"
						+ File.separator + user.getProfile();
				String oldPath = "C:\\Users\\prana\\jsp-servlet1\\TechBlog\\src\\main\\webapp\\" + "pics"
						+ File.separator + oldProfile;
				// out.println(newPath);

				if (!oldProfile.equals("demo.png")) {

					Helper.deleteFile(oldPath);
				}

				if (Helper.saveFile(part.getInputStream(), newPath)) {

					// out.println("<h4>Profile updated successfully</h4>");
					Message mes = new Message("Profile Updated Successfully ,Please refresh !!!", "success",
							"alert-success");
					s.setAttribute("message", mes);

				} else {

					// out.println("<h4>Cannot Saveed</h4>");
					Message mes = new Message("Error !!! Profile Not Updated", "error", "alert-danger");
					s.setAttribute("message", mes);

				}

			} else {
				// out.print("<h4>Error</h4>");
				Message mes = new Message("Error !!! Profile Not Updated", "error", "alert-danger");
				s.setAttribute("message", mes);
			}
			response.sendRedirect("profile.jsp");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
