package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 받은 데이터 꺼내오기
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 2. 조건을 판단(ID : test , PW : 12345)
		if (id.equals("test") && pw.equals("12345")) {
			HttpSession session = request.getSession();	
			// 참일 경우(로그인 정보 일치O)
			// session 생성해서 nickname 저장(쿠키 몬스터)
			// main.jsp이동
			session.setAttribute("nickname", "쿠키몬스터");
			
			response.sendRedirect("main.jsp");
			
		}else {
			// 거짓일 경우(로그인 정보 일치 X)
			response.sendRedirect("loginform.jsp");
		}
		
		
		
	
	}

}
