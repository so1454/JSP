<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><%String id = request.getParameter("id"); %>
	
	 <%=id%>님 환영합니다!</h1>
	
	<a href ="ex05Login.html">로그아웃</a>


</body>
</html>