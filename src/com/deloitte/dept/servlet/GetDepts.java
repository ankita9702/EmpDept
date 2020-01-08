package com.deloitte.dept.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.dao.DeptDao;
import com.deloitte.dept.dao.impl.DeptDaoImpl;

/**
 * Servlet implementation class GetDepts
 */
@WebServlet("/GetDepts")
public class GetDepts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DeptDao dao = new DeptDaoImpl();
		List<Dept> deptlist = dao.getDepartments();
		out.println("<table border=2>");
		out.println("<tr><th>DEPT NO<TH>DEPT NAME<TH>LOCATION</tr>");
		for(Dept d : deptlist){
			out.println("<tr>");
			out.println("<td>"+d.getDeptno()+"</td>");
			out.println("<td>"+d.getDname()+"</td>");
			out.println("<td>"+d.getLoc()+"</td></tr>");
		}
		out.println("</table>");
		out.println("<br><a href=DepartmentHomepage.html>Return to Homepage</a>");
	}
}
