package com.deloitte.dept.dao;

import java.util.List;
import com.deloitte.dept.beans.Dept;

public interface DeptDao {
	void openConnection();
	void close();
	int addDepartment(Dept dept);
	List<Dept> getDepartments();
	Dept getDepartmentByNo(int deptno);
	Dept updateDname(int deptno, String dname);
	Dept updateLoc(int deptno, String loc);
	int deleteRecord(int deptno);
}
