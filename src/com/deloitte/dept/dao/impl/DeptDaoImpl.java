package com.deloitte.dept.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.dao.DeptDao;
import com.deloitte.dept.utils.DeptUtils;

import oracle.jdbc.OracleDriver;

public class DeptDaoImpl implements DeptDao{
	private Connection conn=null;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public void openConnection() { //method to connect to Oracle driver
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
	public void close() {      //method to close connection
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int addDepartment(Dept dept) {             //method to insert Department Information
		openConnection();
		int rows=0;
		try {
			pst = conn.prepareStatement(DeptUtils.INSERT);
			pst.setInt(1, dept.getDeptno());
			pst.setString(2, dept.getDname());
			pst.setString(3, dept.getLoc());
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
	public List<Dept> getDepartments() {                //method to get all Department Records
		openConnection();
		List<Dept> deptlist = new ArrayList<Dept>();
		try {
			pst = conn.prepareStatement(DeptUtils.GETDEPARTMENTS);
			rs = pst.executeQuery();
			while(rs.next()){
				Dept dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return deptlist;
	}
	@Override
	public Dept getDepartmentByNo(int deptno) {          //method to get one Department Record 
		openConnection();
		Dept dept = null;
		try {
			pst = conn.prepareStatement(DeptUtils.GETDEPARTMENTBYNO);
			pst.setInt(1, deptno); 
			rs = pst.executeQuery();
			if(rs.next()){
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return dept;
	}
	@Override
	public Dept updateDname(int deptno, String dname) {          //method to update Department Name
		openConnection();
		Dept dept = null;
		try {
			pst = conn.prepareStatement(DeptUtils.UPADTEDNAME);
			pst.setString(1, dname); 
			pst.setInt(2, deptno); 
			pst.executeUpdate();
			pst=conn.prepareStatement(DeptUtils.GETDEPARTMENTBYNO);
			pst.setInt(1, deptno); 
			rs = pst.executeQuery();
			if(rs.next()){
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return dept;
	}
	@Override
	public Dept updateLoc(int deptno, String loc) {      //method to update Department Location
		openConnection();
		Dept dept = null;
		try {
			pst = conn.prepareStatement(DeptUtils.UPADTELOC);
			pst.setString(1, loc); 
			pst.setInt(2, deptno); 
			pst.executeUpdate();
			pst=conn.prepareStatement(DeptUtils.GETDEPARTMENTBYNO);
			pst.setInt(1, deptno); 
			rs = pst.executeQuery();
			if(rs.next()){
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return dept;
	}
	@Override
	public int deleteRecord(int deptno) {           //method to delete Department Record
		openConnection();
		int rows=0;
		try {
			pst = conn.prepareStatement(DeptUtils.DELETERECORD);
			pst.setInt(1, deptno); 
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return rows;
	}
}
