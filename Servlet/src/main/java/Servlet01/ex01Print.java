package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Print")
public class ex01Print extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected : 상속받은 클래스에서만 사용할 수 있는 메소드 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// sevice 메소드 매개변수
		// ---> client로부터 요청이 들어오는 순간 서버에서 자동으로 매개변수를 받아온다!
		// 1. request 
		// : 클라이언트의 요청 정보를 가지고 있는 객체
			
		// 2.response
		// : 서블릿이 클라이언트 응답을 보낼 때 사용하는 객체
		// : 응답 정보를 가지고 있는 객체
	
		
//		웹 페이지 출력 ---> 응답을 되돌려준다.
		//0. 응답 형식 지정(문서 html 파일, 한글 인코딩)
		// 공식처럼 안에 들어가는 text/html은 항상 같다. 
		// 그리고 / 한글 인코딩 - charset = UTF-8 
		response.setContentType("text/html;charset = UTF-8");
		
		//1. 출력할 수 있는 도구를 꺼내오기
		// JAVA의 스캐너처럼!
//		----> 출력 스트림 열어주기.
		PrintWriter out = response.getWriter();
		
		// 2. 출력하기
//		out.print("<h1>");
//		out.print("Hello World!");
//		out.print("</h1>");

		// 여기서 h3만하면 물음표만나오고 String형태의 타입 출력이 '???'이런식으로 나와서
//			잘 안되는걸 볼 수 있음 (그걸 0번에서 다시 알려주심)
//		out.print("<h3>");
//		out.print("규남쌤반 화이팅");
//		out.print("</h3>");
	
		// 반복문으로 출력해보기 --> 코드블럭을 스니켓(조각..)이라고 한다고
		for (int i = 0 ; i < 3 ; i++ ) {
			out.print("<h3>");
			out.print("규남쌤반 화이팅");
			out.print("</h3>");	
		}
		
	
	
	
	
	
	
	
	
	}

}
