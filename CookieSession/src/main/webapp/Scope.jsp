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
	// JSP에서는 Scope는 전부 내장객체이다.
	// 요청 데이터 꺼내오기
	String r = (String) request.getAttribute("data"); // --> object니까 String으로 강제 형변환 해줌

	// 세션 데이터 꺼내오기
	String s = (String) session.getAttribute("data2");

	// application 데이터 꺼내오기 --> 내장객체임!
	String a = (String) application.getAttribute("data3");
	%>


	<%=r%>
	<%=s%>
	<%=a%>


</body>
</html>