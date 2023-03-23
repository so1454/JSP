package com.smhrd.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	// mybatis - config 파일을 읽어서 sqlsession을 생성하도록 도와주는 도ㅓ구
	
	public static SqlSessionFactory sqlSessionFactory; // 전역변수로 변환
	// 일종의 생성자!
	//인스턴스 생성자
	// ex. Class.forName("driver명칭")
	// --> 제일 먼저 실행되는 구간, 서로 다른 객체끼리 꼭 공유해야하는 고정값	
	static {
		String resource = "com/smhrd/db/mybatis_config.xml"; //my batis 있는곳 지정
		// 프로젝트시 resource 경로만 잘 확인하기(이 위에 리소스만 바꿔주면됨)
		
		InputStream inputStream;		// 입력기능
		try {
			inputStream = Resources.getResourceAsStream(resource);  // resource도 스태틱기반(new로 생성안해주니까)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// sqlsessionfactory 리턴해주는 메소드
	public static SqlSessionFactory getFactory() {
		
		return sqlSessionFactory ; 
		
	}
	
	
	
	
	
	
	
}
