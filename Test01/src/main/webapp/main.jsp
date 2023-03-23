<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = (String) session.getAttribute("nickname");
	%>
	<form action="Logout">

		<table border="1">
			<tr align="center">
				<td><%=name%>님 환영합니다~!~~</td>
			</tr>
			
			<tr>
				<td><input type="submit" value="로그아웃"></td>
			</tr>
	</form>
</body>
</html>