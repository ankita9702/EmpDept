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
 * Servlet implementation class UpdateDeptRecord
 */
@WebServlet("/UpdateDeptRecord")
public class UpdateDeptRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		DeptDao dao = new DeptDaoImpl();
		Dept d = dao.getDepartmentByNo(deptno);
		RequestDispatcher rd;
		if(d==null){
			out.println("<font color=red>Department not found</font>");
			rd=request.getRequestDispatcher("UpdateDepartmentRecord.html");
			rd.include(request, response);
		}
		else{
			String names[] = request.getParameterValues("item");
			try{
				if(names.length>0){
					for(String s : names){
						if(s.equals("dname")){
							String dname = request.getParameter("dname");
							d=dao.updateDname(deptno, dname);
						}
						else if(s.equals("loc")){
							String loc = request.getParameter("loc");
							d=dao.updateLoc(deptno, loc);
						}
					}
					out.println("Updated Record <br>");
					out.println("<table border=2>");
					out.println("<tr><th>DEPT NO<TH>DEPT NAME<TH>LOCATION</tr>");
					out.println("<tr>");
					out.println("<td>"+d.getDeptno()+"</td>");
					out.println("<td>"+d.getDname()+"</td>");
					out.println("<td>"+d.getLoc()+"</td></tr>");
					out.println("</table><br><br>");
					out.println("<a href=UpdateDepartmentRecord.html>Update Another Record</a><br>");
					out.println("<a href=DepartmentHomepage.html>Return to Homepage</a>");
				}
			}
			catch(NullPointerException exp){
				out.println("<font color=red>Enter values to be updated</font><br>");
				rd=request.getRequestDispatcher("UpdateDepartmentRecord.html");
				rd.include(request, response);
			}
		}
	}
}
