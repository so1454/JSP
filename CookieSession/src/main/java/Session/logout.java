package Session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. Session 꺼내오기
		HttpSession session = request.getSession();	
		
		// 2. session 안에 있는 데이터 삭제하기
		session.removeAttribute("nickname"); 
		// session.removeAttribute("name값 ");--> 정확히 한개만 지정해서 삭제할떄
		// session.invalidate(); --> session 안에 저장되어있는 모든 데이터 무효화!
		// 둘 중 편한걸 쓰면됨
		
		// 3. main으로 이동 //	--> null님 환영합니다. 라고 나옴!(session이 삭제된걸 확인 할 수 있음)
		response.sendRedirect("main.jsp");
	}

}
