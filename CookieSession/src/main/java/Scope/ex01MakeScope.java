package Scope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeScope")
public class ex01MakeScope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Scope (유효범위)
		// : 웹 서버에서 생성한 변수, 객체들이 어디까지 사용 가능한지
		// 유효할 수 있는 범위
		// >> 총 4가지의 유효범위

		// 1. page
		// >> 하나의 page 안에서만 공유 가능한 데이터

		// 2. request
		// >> 하나의 요청과 관련된 데이터
		// >> 요청하는 페이지, 응답을 돌려주는 페이지 공유 가능
		// >> 응답이 돌아오기 전까지 사용이 가능하다
		request.setAttribute("data", "request scope");

		// 3. session
		// >> 하나의 브라우저와 관련된 데이터
		// >> 브라우저가 종료되기 전까지 데이터 공유
		request.getSession().setAttribute("data2", "Session scope");
		// request.getSession() --> 자체가 HTTP Session 이다!

		// 4. application
		// >> 하나의 웹 어플리 케이션 관련된 데이터
		// >> 서버가 종료되기 전까지 데이터 공유
		request.getServletContext().setAttribute("data3", "application scope");

		// 원래 페이지 이동할 때 썼던거!
		// sendRedirect 방식
		// >> 요청 2번, 응답 두번 : request 영역을 확인하기 불가능!

		// 그래서
		// forward방식 ★★★★★★★★★★짱 중요
		// >> 요청1번, 응답1번 페이지 이동이 가능!
		// >> 페이지 url에 변동이 일어나지 않는다!
		
		RequestDispatcher rd = request.getRequestDispatcher("Scope.jsp");
		rd.forward(request, response);
		
		
		
		

	}

}
