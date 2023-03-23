package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;


public class LoginService implements Command {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		try {

			request.setCharacterEncoding("UTF-8");

			String email = request.getParameter("email");
			String pw = request.getParameter("pw");

			MemberDTO dto = new MemberDTO();
			dto.setEmail(email);
			dto.setPw(pw);

			MemberDAO dao = new MemberDAO();

			MemberDTO tlogin = dao.login(dto); // 여기서 쓰는 dao를 만들어줘야겠죠! -> dao로 넘어가기

			if (tlogin != null) {

				HttpSession session = request.getSession();
				session.setAttribute("user", tlogin); // user라는 모든 정보를
//				response.sendRedirect("main.jsp"); // 메인으로 보내줌(메인에서는 모든 데이터 받기 가능)


			} else {

				// 7. main.jsp로 redirect방식 이동
//				response.sendRedirect("main.jsp");


			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return "main.jsp";
	}

}
