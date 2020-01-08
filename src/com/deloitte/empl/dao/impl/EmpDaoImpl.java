package com.deloitte.empl.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.deloitte.empl.beans.Emp;
import com.deloitte.empl.dao.EmpDao;
import com.deloitte.empl.utils.ConvertDate;
import com.deloitte.empl.utils.EmpUtils;
import oracle.jdbc.OracleDriver;

public class EmpDaoImpl implements EmpDao{
	private Connection conn=null;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public void openConnection() {      //method to connect to Oracle driver
		try {
			DriverManager.registerDriver(new OracleDriver());
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pass = "tiger";
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	@Override
	public void close() {           //method to close connection
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addEmp(Emp emp) {               //method to insert Employee Record
		openConnection();
		int rows=0;
		try {
			pst = conn.prepareStatement(EmpUtils.insertqry);
			pst.setInt(1, emp.getEmpno());
			pst.setString(2, emp.getEname());
			pst.setString(3, emp.getJob());
			pst.setInt(4, emp.getMgr());
			pst.setDate(5, ConvertDate.parseDate(emp.getHiredate()));
			pst.setDouble(6, emp.getSal());
			pst.setDouble(7, emp.getComm());
			pst.setInt(8, emp.getDeptno());
			rows= pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			close();
		}
		return rows;
	}
	@Override
	public List<Emp> getEmpls() {          //method to get all Employee Records
		openConnection();
		List<Emp> emplist = new ArrayList<Emp>();
		try {
			pst = conn.prepareStatement(EmpUtils.GETEMPLS);
			rs = pst.executeQuery();
			while(rs.next()){
				Emp emp = new Emp(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
					rs.getDouble(7), rs.getInt(8));
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emplist;
	}
	@Override
	public Emp getEmpByCode(int empcode) {         //method to get one Employee Record 
		openConnection();
		Emp emp = null;
		try {
			pst = conn.prepareStatement(EmpUtils.GETEMPlBYCODE);
			pst.setInt(1, empcode); 
			rs = pst.executeQuery();
			if(rs.next()){
				emp = new Emp(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
					rs.getDouble(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emp;
	}
	@Override
	public Emp updateSalary(int empno, double salary) {      //method to update Employee Salary
		openConnection();
		Emp emp = null;
		try {
			pst = conn.prepareStatement(EmpUtils.UPADTESALARY);
			pst.setDouble(1, salary); 
			pst.setInt(2, empno); 
			pst.executeUpdate();
			pst=conn.prepareStatement(EmpUtils.GETEMPlBYCODE);
			pst.setInt(1, empno); 
			rs = pst.executeQuery();
			if(rs.next()){
				emp = new Emp(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
					rs.getDouble(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emp;
	}
	@Override
	public Emp updateCommision(int empno, double comm) {        //method to update Employee Commission
		openConnection();
		Emp emp = null;
		try {
			pst = conn.prepareStatement(EmpUtils.UPADTESALARY);
			pst.setDouble(1, comm); 
			pst.setInt(2, empno); 
			pst.executeUpdate();
			pst=conn.prepareStatement(EmpUtils.GETEMPlBYCODE);
			pst.setInt(1, empno); 
			rs = pst.executeQuery();
			if(rs.next()){
				emp = new Emp(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
					rs.getDouble(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emp;
	}
	@Override
	public int deleteRecord(int empno) {            //method to delete Employee Record
		openConnection();
		int rows=0;
		try {
			pst = conn.prepareStatement(EmpUtils.DELETERECORD);
			pst.setInt(1, empno); 
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return rows;
	}
	@Override
	public Emp updateManager(int empno, int mgr) {        //method to update Employee's Manager ID
		openConnection();
		Emp emp = null;
		try {
			pst = conn.prepareStatement(EmpUtils.UPADTEMANAGER);
			pst.setInt(1, mgr); 
			pst.setInt(2, empno); 
			pst.executeUpdate();
			pst=conn.prepareStatement(EmpUtils.GETEMPlBYCODE);
			pst.setInt(1, empno); 
			rs = pst.executeQuery();
			if(rs.next()){
				emp = new Emp(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
					rs.getDouble(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emp;
	}
	@Override
	public Emp updateJob(int empno, String job) {         //method to update Employee's Job Title
		openConnection();
		Emp emp = null;
		try {
			pst = conn.prepareStatement(EmpUtils.UPADTEJOB);
			pst.setString(1, job); 
			pst.setInt(2, empno); 
			pst.executeUpdate();
			pst=conn.prepareStatement(EmpUtils.GETEMPlBYCODE);
			pst.setInt(1, empno); 
			rs = pst.executeQuery();
			if(rs.next()){
				emp = new Emp(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
					rs.getDouble(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emp;
	}
	@Override
	public Emp updateDeptno(int empno, int deptno) {        //method to update Employee's Department No.
		openConnection();
		Emp emp = null;
		try {
			pst = conn.prepareStatement(EmpUtils.UPADTEDEPTNO);
			pst.setInt(1, deptno); 
			pst.setInt(2, empno); 
			pst.executeUpdate();
			pst=conn.prepareStatement(EmpUtils.GETEMPlBYCODE);
			pst.setInt(1, empno); 
			rs = pst.executeQuery();
			if(rs.next()){
				emp = new Emp(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
					rs.getDouble(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emp;
	}
}
