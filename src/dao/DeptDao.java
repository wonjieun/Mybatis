package dao;

import java.util.List;

import dto.Dept;

public interface DeptDao {
	
	public Dept selectByDeptNo(int deptNo);
	
	public List selectAll();
	
	public void insert(Dept insertDept);
	
}
