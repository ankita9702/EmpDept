package com.deloitte.dept.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		session.setAttribute("login", true);
		if(user.isEmpty() || password.isEmpty()){
			out.println("<font color=red>Username/Password are mandatory</font>");
			rd=request.getRequestDispatcher("LogIn.html");
			rd.include(request, response);
		}
		else if(user.equals("admin") && password.equals("admin")){
			rd = request.getRequestDispatcher("Admin");
			rd.include(request, response);	
		}
		else if(!user.equals("admin")){
			rd = request.getRequestDispatcher("User");
			rd.include(request, response);	
		}
		else{
			out.println("<font color=red>Invalid Username</font>");
			rd=request.getRequestDispatcher("LogIn.html");
			rd.include(request, response);
		}	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
