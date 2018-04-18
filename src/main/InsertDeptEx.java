package main;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.DeptDao;
import dto.Dept;
import mybatis.MybatisConnectionFactory;

public class InsertDeptEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Dept insertDept = new Dept();
		
		System.out.print("부서번호 입력: ");
		insertDept.setDeptNo( sc.nextInt() );
		sc.skip("\r\n");
		System.out.print("부서이름 입력: ");
		insertDept.setdName( sc.nextLine() );
		System.out.print("부서위치 입력: ");
		insertDept.setLoc( sc.nextLine() );

		// 입력 확인
		System.out.println(insertDept);
		
		// Auto commit X
		SqlSession sqlSession = MybatisConnectionFactory
				.getSqlSessionFactory()
//				.openSession(true);  // Auto commit O
				.openSession();
		
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);

		// TEST DATA
//		insertDept.setDeptNo(2);
//		insertDept.setdName("B");
//		insertDept.setLoc("BUSAN");

		// 입력 확인
//		System.out.println(insertDept);
		
		deptDao.insert(insertDept);

		// 인덱스가 있다 하더라도 조회가 부담스럽다
		Dept result = deptDao.selectByDeptNo(insertDept.getDeptNo());
		// 훨씬 빠르다
//		int cnt = deptDao.countByDeptBy(insertDept.getDeptNo());
		
		if( result == null ) {
			sqlSession.rollback();
			System.out.println("부서정보 삽입 실패");
		} else {
			sqlSession.commit();
			System.out.println("부서정보 삽입 성공");
		}

	}
}
