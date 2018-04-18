package main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.DeptDao;
import dto.Dept;
import mybatis.MybatisConnectionFactory;

public class MyBatisEx {
	public static void main(String[] args) {
		// DB 접속 객체
		SqlSession sqlSession = MybatisConnectionFactory
								.getSqlSessionFactory()
								.openSession();
		// DAO 실제 구현체
		// 예전에 했던 daoImpl(jdbc부분)을 mapper.xml파일로 대체 
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		
		Dept resultDept = deptDao.selectByDeptNo(10);
		System.out.println(resultDept);
		
		System.out.println("-----");
		List list = deptDao.selectAll();
		System.out.println(list);
	}
}
