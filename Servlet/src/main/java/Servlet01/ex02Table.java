package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Table")
public class ex02Table extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset = UTF-8");

		PrintWriter out = response.getWriter();

		out.print("<table border = '1'> ");
		out.print("<tr>");

		for (int i = 1; i <= 6; i++) {
			// 행 : tr(table rows)
			// 열 : td(table data)
			out.print("<td rowspan = '3' align = 'center'>");

			out.print("<h3>");
			out.printf("%d", i);
			out.print("</h3>");

			out.print("</td>");
		}

		out.print("</tr>");
		out.print("</table>");

	}

}
