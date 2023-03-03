package GetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class ex01Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// post 방식으로 했는데 한글이 깨질때 (get은 안해줘도됨)
		// 요청받은 데이터 꺼내오기 전에!
		// 0. post 방식일때 요청받은 데이터 한글 인코딩 해주기!(간단해!)
		request.setCharacterEncoding("UTF-8");
		
		// 1. 요청받은 데이터 꺼내오기
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		// 2. 응답 형식 지정
		response.setContentType("text/html;charset = UTF-8");

		// 3.출력 스트림 꺼내오기 
		PrintWriter out = response.getWriter();

		// 4. 로그인 성공 실패 여부 판단하기
		if (id.equals("smart") && pw.equals("123")) {
			//5. 성공시 ~님 환영합니다.
			out.print(id+"님 환영합니다");
		}else {
			//5. 실패시 로그인 정보를 확인해주세요
			out.print("로그인 정보를 확인해주세요");
			out.print("입력한 ID : "+id);
			
		}
		

	}

}
