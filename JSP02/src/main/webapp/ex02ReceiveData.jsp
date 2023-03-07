<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// request 내장객체 사용하기
		// 1. 요청받은 데이터 꺼내오기
		String data = request.getParameter("data");
		
	
		// 2. 화면에 요청받은 데이터 h1태그 사용해서 출력하기
	
	%>
	<h1><%=data%></h1>	
	
	
</body>
</html>