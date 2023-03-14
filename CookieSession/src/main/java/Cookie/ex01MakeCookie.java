package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeCookie")
public class ex01MakeCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// servlet이 서버쪽 jsp 가 client쪽이라고 생각하고 실습진행하기!
		
		// Sever(쿠키 생성하는 곳)
		
		// 1. 쿠키 생성하기
		Cookie cookie = new Cookie("data", "cookieData");
		
		// 쿠키의 만료기한
		// >> 별도로 설정하지 않는다면 만료기한은 Session 표기
		// >> 브라우저가 종료되기 전까지만 보관하겠다 라는 의미!
		cookie.setMaxAge(31536000);
		// setMaxAge(초단위)
		
		// 쿠키 지우는 방법
		// cookie.setMaxAge(0)
		
		// 2. 쿠키를 http 헤더에 포함시켜서 응답에 담아주기
		// >> 응답에 담아주기 전에 쿠키에 대한 모든 설정을 끝내야한다!!(다 이 위에 적어야한다는말!)
		response.addCookie(cookie);
		
		// 3. ex01Cookie.jsp 이동
		response.sendRedirect("ex01Cookie.jsp");
		
		
		
	
	
	
	
	}

}
