package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그아웃 요청시 session에 저장된 데이터 삭제!

		// 1. session 영역 생성
		
		HttpSession session = request.getSession();	

		// 2. session에 들어있는 "user"정보 삭제!
		//	- remove()
		// 	- invalidate()
		
		session.removeAttribute("user"); 
//		session.invalidate(); // 세션 다 삭제하겠다(안에 있는 정보 전부 다)
		
		// 3. redirect로 main.jsp 이동
		response.sendRedirect("main.jsp");

	}

}
