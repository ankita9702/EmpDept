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

import com.deloitte.empl.dao.EmpDao;
import com.deloitte.empl.dao.impl.EmpDaoImpl;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try{
			if((boolean) session.getAttribute("login")){
				String user = request.getParameter("user");
				out.println("Welcome "+user+"<br><br>");
				EmpDao dao = new EmpDaoImpl();
				dao.getEmpByCode(Integer.parseInt(user));
			}
		}
		catch(NullPointerException e){
			out.println("<font color=red>Unauthorized Access</font><br>");
			out.println("<font color=red>Please Log in</font><br>");
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("LogIn.html");
			rd.include(request, response);
		}
	}
}
