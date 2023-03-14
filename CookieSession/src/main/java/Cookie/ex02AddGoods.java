package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddGoods")
public class ex02AddGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// 1. 요청 받은 데이터 꺼내오기
		String[] product = request.getParameterValues("product");
		
		// 2. 요청받은 데이터들의 갯수만큼 쿠키를 생성
		for (int i = 0; i < product.length ; i++) {
			Cookie cookie = new Cookie("product"+i, product[i]);
			
			cookie.setMaxAge(1);
			// 3. 생성된 쿠키를 응답 객체에 담아주기
			
			response.addCookie(cookie);
		}
		
		// 4. Shop.jsp로 이동
		response.sendRedirect("Shop.jsp");
		
		
	
	}

}
