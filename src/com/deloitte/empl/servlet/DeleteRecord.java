package com.deloitte.empl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.empl.beans.Emp;
import com.deloitte.empl.dao.EmpDao;
import com.deloitte.empl.dao.impl.EmpDaoImpl;

/**
 * Servlet implementation class DeleteRecord
 */
@WebServlet("/DeleteRecord")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int empno = Integer.parseInt(request.getParameter("empno"));
		EmpDao dao = new EmpDaoImpl();
		Emp e = dao.getEmpByCode(empno);
		RequestDispatcher rd;
		if(e==null){
			out.println("<font color=red>Employee not found</font>");
			rd=request.getRequestDispatcher("DeleteRecord.html");
			rd.include(request, response);
		}
		else{
			int rows = dao.deleteRecord(empno);
			if(rows>0)
				out.println("deleted");
			
			else
				out.println("not deleted");
			out.println("<a href=DeleteRecord.html>Delete Another Record</a><br>");
			out.println("<a href=EmployeeHomepage.html>Return to Homepage</a>");
		}
	}
}
