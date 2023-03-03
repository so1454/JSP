package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/op")
public class ex05Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// servlet에서 실행하면 500에러가 뜸
		
		//1. 요청 받은 데이터 꺼내오기 (3개)
		String temp1 = request.getParameter("num1");
		String temp2 = request.getParameter("num2");
		String op = request.getParameter("op");
		
		// 2. 문자형을 숫자형태로 변환
		int num1 = Integer.parseInt(temp1);
		int num2 = Integer.parseInt(temp2);
		
		// 3. 응답형식 지정
		response.setContentType("text/html;charset = UTF-8");
		
		// 4. 출력스트림 꺼내오기
		PrintWriter out = response.getWriter();
		
		// 5. 연산기호에 따라 연산 결과를 구해주기 (if문 사용)
		int result = 0;
		
		if(op.equals("+")) {
			result = num1 + num2;
			
		}else if(op.equals("-")) {
			result = num1 - num2;
		}else if(op.equals("*")) {
			result = num1 * num2;
		}else if(op.equals("/")) {
			result = num1 / num2;
		}
		
		
		out.print(num1 + op + num2 + "=" + result);
		
		// 6. 결과 출력하기
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
