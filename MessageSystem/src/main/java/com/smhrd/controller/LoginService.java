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

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 한글 인코딩 잡아주기
		request.setCharacterEncoding("UTF-8");
	
		// 2. 요청받은 데이터 꺼내오기(2개)
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
	

		
		//아 이렇게만 해도 수정이 되나봄,, 담아줘야하는줄,,
		MemberDTO dto = new MemberDTO();
		dto.setEmail(email);
		dto.setPw(pw);
		
		// 4. dao생성하기
		MemberDAO dao = new MemberDAO();

		
		// 5. 로그인 기능 수행하기
		// dao에 있는 login에 dto를 담아줌(dto의 
		MemberDTO tlogin = dao.login(dto);  // 여기서 쓰는 dao를 만들어줘야겠죠! -> dao로 넘어가기
							// 여기서 값을 받아온 dto를 넣어야되니까
		// 그리고 MemberDTO tlogin에 담아줌(정보를!)
	


		if ( tlogin != null ){
			// getEmail해서 정보를 받아와! 그리고 확인해 이메일이 있으면 로그인이 되겠지
			
			// 6. 로그인 성공했다면 session로그인 정보 저장
			HttpSession session = request.getSession();
			session.setAttribute("user", tlogin);	// user라는 모든 정보를
			response.sendRedirect("main.jsp");		// 메인으로 보내줌(메인에서는 모든 데이터 받기 가능)
			
		}else {
			// 근데, email이 없으면 로그인이 되지 않겠지
			
			// 7. main.jsp로 redirect방식 이동
			response.sendRedirect("main.jsp");
			
		}

		
		
		
	}

}
