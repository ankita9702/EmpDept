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
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try{
			if((boolean) session.getAttribute("login")){
				out.println("<h2>Welcome Administrator!!!</h2>");
				out.println("<h3>Select Action to be performed</h3><br>");
				out.println("<a href=DepartmentHomepage.html>   Department Operations</a><br>");
				out.println("<a href=EmployeeHomepage.html>   Employee Operations</a><br>");
			}
		}
		catch(NullPointerException e){
			out.println("<font color=red>Unauthorized Access</font><br>");
			out.println("<font color=red>Please Log in</font><br>");
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
	}
}
