package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

@WebServlet("/updateServie")
public class updateServie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// 1. 한글 인코딩 설정해주기 post 방식이니까
		request.setCharacterEncoding("UTF-8");
		
		// 2. 수정하고자 넘겨준 데이터 꺼내오기
		
		// form태그에서 받은 정보만 getparameter 할 수 있음
		String pw = request.getParameter("pw");		
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		
//		+) 수정하고자 하는 회원의 email 필요!(정보 일치하는지 확인용) -> session으로 부터 가져오기! 
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("user"); 
		// 로그인 회원의 전 정보를 가져옴(로그인에서 받아온거임)
		// session이 OBject라서 형변환이 필요함
		String email = dto.getEmail();
		
		
		
		// 3. 데이터 MemberDTO형태로 묶어주기
		dto = new MemberDTO(email,pw,tel,address); // 새롭게 DTO로 묶어줌
		
		
		// 4. DAO로 접근할 수 있는 메소드 사용 (DAO -> update() )
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.update(dto);  // 묶어준 dto를 담음
		
		
		if ( cnt > 0  ){ // cnt는 데이터가 담겼는지 아닌지 확인용
			// 성공했을때!
			// 내가 user라는 세션을 가지고 갈꺼야 dto를 넣어서
			// 수정된 내용을 기억하면서 main으로 넘어 갈 수 있도록 설계!
			session.setAttribute("user", dto);	
					
		}else {
			//실패시
			
		}
		
		response.sendRedirect("main.jsp");
		
		
		
	
	
	
	
	
	
	}

}
