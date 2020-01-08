package com.deloitte.dept.beans;

public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	public Dept() { //non-parameterized constructor
		super();
	}
	public Dept(int deptno, String dname, String loc) { //parameterized constructor
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	//getter and setter methods
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
