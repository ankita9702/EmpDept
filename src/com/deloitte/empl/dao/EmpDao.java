package com.deloitte.empl.dao;

import java.util.List;
import com.deloitte.empl.beans.Emp;

public interface EmpDao {
	void openConnection();
	void close();
	int addEmp(Emp emp); 
	List<Emp> getEmpls();
	Emp getEmpByCode(int empcode);
	Emp updateSalary(int empno, double salary);
	Emp updateCommision(int empno, double comm);
	Emp updateManager(int empno, int mgr);
	Emp updateJob(int empno, String job);
	Emp updateDeptno(int empno, int deptno);
	int deleteRecord(int empno);
}
