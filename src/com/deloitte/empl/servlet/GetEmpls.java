package com.deloitte.empl.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.deloitte.empl.beans.Emp;
import com.deloitte.empl.dao.EmpDao;
import com.deloitte.empl.dao.impl.EmpDaoImpl;

/**
 * Servlet implementation class GetEmpls
 */
@WebServlet("/GetEmpls")
public class GetEmpls extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		out.println("City = "+ctx.getInitParameter("city"));*/
		EmpDao dao = new EmpDaoImpl();
		List<Emp> emplist = dao.getEmpls();
		/*out.println("<table border=2>");
		out.println("<tr><th>EMP NO<TH>EMP NAME<TH>JOB<TH>MGR<TH>HIRE DATE<TH>SALARY<TH>COMMISION<TH>DEPT NO</tr>");
		for(Emp e : emplist){
			out.println("<tr>");
			out.println("<td>"+e.getEmpno()+"</td>");
			out.println("<td>"+e.getEname()+"</td>");
			out.println("<td>"+e.getJob()+"</td>");
			out.println("<td>"+e.getMgr()+"</td>");
			out.println("<td>"+e.getHiredate()+"</td>");
			out.println("<td>"+e.getSal()+"</td>");
			out.println("<td>"+e.getComm()+"</td>");
			out.println("<td>"+e.getDeptno()+"</td></tr>");
		}
		out.println("</table>");
		out.println("<br><a href=EmployeeHomepage.html>Return to Homepage</a>");*/
		request.setAttribute("empls", emplist); 
		request.getRequestDispatcher("ViewEmpls.jsp").forward(request, response); 
	}
}
