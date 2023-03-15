package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {
//		DAO ==> 데이터베이스에 접근했던 클래스! 데이터베이스에 있는 데이터에 접근 도와주는 객체

	// 1. factory 가지고 오기 (sqlsession을 빌려올 수 있는 공장)
	//	-> private는 여기서만 쓰게 묶어주는 거임
	private SqlSessionFactory factory = SqlSessionManager.getFactory();
	
	public int join(MemberDTO dto) {
		int cnt = 0;
		// 회원가입 기능 수행 --> 데이터 베이스에 데이터 추가하기
		
		// 데이터베이스 접근하려면 connection(sqlsession)필요
		// 1. sqlsession빌려오기
		SqlSession session = factory.openSession(true);  // boolean으로 autocommit해줌 
		
		try {
			// 2. mapper.xml파일 안에 있는 sql구문 중에 사용하고 싶은 sql구문 정해주기(여기서 memberMapper가서 sql구문 써주고옴)
			// session.insert("mapper식별자.sql구문 식별자", mapper파일로 넘기고 싶은 매개변수)
			
			// mapper식별자는 meberMapper.xml의 namespace 보기
			// 그리고 sql 식별자는 meberMapper의 insert의 id로 지정
			// mapper파일로 넘기고 싶은 매개변수.xml은 여기서 지정해준 dto!
			
			cnt = session.insert("com.smhrd.model.MemberDAO.join", dto);
								//전체 com.smhrd.model.MemberDAO.join or 구문식별자!
		} finally {
			//3. sqlsession반납하기
			session.close();
			
		}
		return cnt;
	}

	
	
	
	
}
