package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

public class JoinService implements Command {

	String moveUrl = null;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			// 1. 한글 인코딩 잡아주기
			request.setCharacterEncoding("UTF-8");

			// 2. 요청받은 데이터들을 꺼내오기
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			// 3. 요청받은 데이터들을 하나의 자료형으로 묶어주기
			MemberDTO dto = new MemberDTO(email, pw, tel, address);

			// 4. 회원가입 기능 수행하기
			// --> 데이터베이스 연결과 관련된 기능을 쓰겠다!

			MemberDAO dao = new MemberDAO();
			int cnt = dao.join(dto); // --> dao에 dto를 담아줄꺼야~
			// --> DAO에서 지정해준 리턴타입 int cnt에 담아줌

			if (cnt > 0) {
				// 5. 회원가입 성공했다면 join_success.jsp로 forward 방식 이동
				// --> request scope 영역에 회원가입한 email을 저장해서 이동
				request.setAttribute("email", email);
//				RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
//
//				rd.forward(request, response);

				moveUrl = "join_success.jsp";

			} else {

				// 6. 회원가입 실패했다면, main.jsp redirect방식 이동
//				response.sendRedirect("main.jsp");

				moveUrl = "main.jsp";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moveUrl;
	}

}