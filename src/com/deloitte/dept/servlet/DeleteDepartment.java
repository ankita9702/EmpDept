package com.deloitte.dept.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.dao.DeptDao;
import com.deloitte.dept.dao.impl.DeptDaoImpl;

/**
 * Servlet implementation class DeleteDepartment
 */
@WebServlet("/DeleteDepartment")
public class DeleteDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		DeptDao dao = new DeptDaoImpl();
		Dept e = dao.getDepartmentByNo(deptno);
		RequestDispatcher rd;
		if(e==null){
			out.println("<font color=red>Department not found</font>");
			rd=request.getRequestDispatcher("DeleteDepartment.html");
			rd.include(request, response);
		}
		else{
			int rows = dao.deleteRecord(deptno);
			if(rows>0)
				out.println("deleted<br>");
			
			else
				out.println("not deleted<br>");
			out.println("<a href=DeleteDepartment.html>Delete Another Record</a><br>");
			out.println("<a href=DepartmentHomepage.html>Return to Homepage</a>");
		}
	}

}
