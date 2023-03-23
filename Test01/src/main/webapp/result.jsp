<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name"); 
		String[] fruit = request.getParameterValues("fruit");
		 
		%>
		<table border="1">
			<tr align = "center">
				<td>이름</td>
				<td colspan = "2"><%=name %>  </td>
			</tr>
			<tr>
				<td>좋아하는 과일</td>
				<td >
				<%for (int i = 0 ; i < fruit.length ; i ++){
					%>
				<%=fruit[i] %> 
				<%}%>
				</td>
			</tr>

			
		</table>



</body>
</html>