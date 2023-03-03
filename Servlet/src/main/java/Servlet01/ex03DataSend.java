package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataSend")
public class ex03DataSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		//요청을 받는 공간(데이터를 가져오는공간!) HTML에서 요청을 받아올 것임 그것을 동적으로 처리할것임
	
		// 1. 요청받은 데이터 꺼내기
		// 요청과 관련정보는 request!
		 String data = request.getParameter("data");
		 //이건 콘솔창에 출력하기
//		 System.out.println("요청받은 데이터 >> " +data);
	
		 // ex ) 요청받은 데이터 --> 김운비
		 // 김운비님 환영합니다! 웹페이지에 출력하기
		 
		 // ex) 요청받은 데이터 --> 강규남
		 // 강규남님 환영합니다! 웹페이지에 출력하기
		 
		 // 2. 응답형식 지정하기
		 response.setContentType("text/html;charset = UTF-8");
		 
		 //3. 출력스트림 꺼내오기
		 PrintWriter out = response.getWriter();
		 
		 //4. 요청받은 데이터를 웹페이지에 출력하기
		 out.print("<h2>");
		 out.print( data+"님 환영합니다!");
		 out.print("</h2>");
	
	
	
	
	
	}

}
