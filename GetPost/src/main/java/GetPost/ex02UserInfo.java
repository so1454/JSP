package GetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfo")
public class ex02UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");

		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
		
		
		// 하나의 name값에 요청받은 값이 여러개일때 꺼내오는 방법
		// --> request.getParameterValues("name값")
		String[] sports = request.getParameterValues("sports");

		response.setContentType("text/html;charset = UTF-8");

		PrintWriter out = response.getWriter();

		out.print("직업 : " + job);
		out.print("<br>");
		out.print("성별 : " + gender);
		out.print("<br>");

		out.print("취미 : ");
//		for - each.? 배열의 데이터를 꺼내서 string s라는 데이터에 담아주는(python과 비슷한 기능)
		for(String s : sports) {
			out.print(s + " ");
		}
		
//		for (int i = 0; i < sports.length; i++) {
//			out.print(sports[i] + " ");
//		}

	}

}
