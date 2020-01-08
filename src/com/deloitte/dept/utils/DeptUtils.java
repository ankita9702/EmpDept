package com.deloitte.dept.utils;

public class DeptUtils {
	public static String INSERT="insert into dept values(?,?,?)";
	public static final String GETDEPARTMENTS = "select * from dept";
	public static final String GETDEPARTMENTBYNO = "select * from dept where deptno=?";
	public static final String UPADTEDNAME = "update dept set dname=? where deptno=?";
	public static final String UPADTELOC = "update dept set loc=? where deptno=?";
	public static final String DELETERECORD = "delete from dept where deptno=?";
}
