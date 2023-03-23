package com.smhrd.Frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.controller.LoginService;

@WebServlet("*.do")
// *.do -> 전체 파일을 .do 라는 확장자로 mapping하여, 
// .do가 붙어있는 경우 어떤 요청이라도 ForntController로 연결하겠다!

public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청된 uri 주소가 어디인지 확인!
		String uri = request.getRequestURI();
		System.out.println("요청된 uri" + uri);

		// 2. 프로젝트의 이름 확인!
		String path = request.getContextPath();
		System.out.println("요청된 프로젝트" + path);

		// 3. 1~2번을 활용하여 필요한 요청 이름 확인!
		String result = uri.substring(path.length() + 1);
		System.out.println("result : " + result);
		
		
		//----------------------------------------------------------
		
		// 담아줄 변수 선언
		String moveURL = null; 
		
		// 원래 각자의 서블릿이 컨트롤러에 전부 들어있었는데 다 여기로 묶어줄꺼야!!
		// 근데 여기에 전부 다 넣어주면 진짜...너무..힘들꺼같겠지?
		// 가벼워지고 좋겠지만, 수정이나 삭제하는게 쉽지 않음 -> 그래서 커멘드 패턴이라는 것이 있음)
		// 여기서 넘어가서 커멘드 패턴을 만들어봄
		// 요청된 내용에 따라 기능 연결!
		if (result.equals("Login.do")) {
			
			// Command가 가지고 있는 execute() 사용하여
			// 각각의 클래스 실행!
			LoginService login = new LoginService();
			
			// loginService 안의 메소드가 가진 execute를 불러와줌
			moveURL = login.execute(request, response); // execute가 가지고 있는 request response는
											// 이 친구가 가지고 있는거 가져다가 쓸꺼임
			// 로그인 클래스.excute();
			
			// 담아주 moveURL은 전부 다 확인 후 if문 밖에서 확인해서 페이지 이동 해줄꺼임
			

		} else if (result.equals("Join.do")) {
			
			
			
			
			
			
			
			

		} else if (result.equals("Update.do")) {

		} else if (result.equals("Logout.do")) {

		} else if (result.equals("SelectAll.do")) {

		} else {
			System.out.println("잘못된 요청값");
		}
		
		// 조건문에 따라 판단된 moveURL 페이지 이동 진행하기! 
		RequestDispatcher rd = request.getRequestDispatcher(moveURL);
		rd.forward(request, response);

	}

}
