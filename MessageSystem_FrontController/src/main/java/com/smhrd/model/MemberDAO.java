package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {
//		DAO ==> 데이터베이스에 접근했던 클래스! 데이터베이스에 있는 데이터에 접근 도와주는 객체

	// 1. factory 가지고 오기 (sqlsession을 빌려올 수 있는 공장)
	// -> private는 여기서만 쓰게 묶어주는 거임
	private SqlSessionFactory factory = SqlSessionManager.getFactory();
	int cnt = 0;

	public int join(MemberDTO dto) {
		// 회원가입 기능 수행 --> 데이터 베이스에 데이터 추가하기

		// 데이터베이스 접근하려면 connection(sqlsession)필요
		// 1. sqlsession빌려오기
		SqlSession session = factory.openSession(true); // boolean으로 autocommit해줌

		try {
			// 2. mapper.xml파일 안에 있는 sql구문 중에 사용하고 싶은 sql구문 정해주기(여기서 memberMapper가서 sql구문
			// 써주고옴)
			// session.insert("mapper식별자.sql구문 식별자", mapper파일로 넘기고 싶은 매개변수)

			// mapper식별자는 meberMapper.xml의 namespace 보기
			// 그리고 sql 식별자는 meberMapper의 insert의 id로 지정
			// mapper파일로 넘기고 싶은 매개변수.xml은 여기서 지정해준 dto!

			cnt = session.insert("com.smhrd.model.MemberDAO.join", dto);
			// 전체 com.smhrd.model.MemberDAO.join or 구문식별자!
		} finally {
			// 3. sqlsession반납하기
			session.close();

		}
		return cnt;
	}

	public MemberDTO login(MemberDTO dto) {
		// 1. sesion빌려오기
		SqlSession session = factory.openSession(true);
		MemberDTO DtoLogin = null;

		try {
			// 2. session활용해서 구문실행(로그인 기능)
			// 이메일을 pk로 둬서 중복이 안되니까 어차피 일치하는 건 하나밖에 없을 것임
			// 그래서 selectOne사용
			DtoLogin = session.selectOne("login", dto);
			// dto를 담아서 가져가줘야하니까 selectone안에 두 값을 받아야함

		} finally {
			// 3. seission반납
			session.close();
		}

		// 4. 결과값 반환
		return DtoLogin;

	}

	
	
	
	public int update(MemberDTO dto) {  // update에서 memberDTO를 받아올꺼다.
		//1. sqlsession 빌려오기
		SqlSession session = factory.openSession(true);
		int cnt = 0;
		try {
			// 2. session활용해서 sql구문 실행
			 cnt = session.update("update", dto);

		} finally {
			// 3. session반납
			session.close();
		}

		return cnt;

	}

	public ArrayList<MemberDTO> selectAll() {
		
		SqlSession session = factory.openSession(true);
		
		ArrayList<MemberDTO> list = new ArrayList<>();

		
		try {
			// 2. session 활용해서 sql 구문 실행 -> selectList()
			// --> 매개변수 고민(10시 20분 수업)
			list = (ArrayList) session.selectList("selectAll");
			
			// arraylist로 쓰면 다운캐스팅 해줘야함 (ArrayList) session.selectList()~~
		}finally {
			// 3. session 반납
			session.close();
		}
		
		return list;
		
		
	}

}
