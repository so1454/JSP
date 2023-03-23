package com.smhrd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

@WebServlet("/SelectAllProgram")
public class SelectAllProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// 요청한 정보도 없고 중간에서 연결을 할 친구니까 바로
		// 1. DAO 생성
		MemberDAO dao = new MemberDAO();
		
		// 2. DAO 실행할 메소드 호출! -> selectAll() 생성
		
		ArrayList<MemberDTO> list = dao.selectAll();
		
		// 3. 성공시 사용자의 정보 request 객체에 전달!
		
		if (list != null) {
			//성공시		.setAttribute("이름", 데이터)
			request.setAttribute("list", list);
			// 4. 마지막으로 해당 request를 가지고 페이지 이동!(request유지할 수 있도록 forward 방식사용)
			RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
			
			rd.forward(request, response);
			
		}else {

			//실패시
			
			
		}
	}

}
