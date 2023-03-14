<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
	//client 데이터를 가지고 페이지 이동 흐름 제어(따로 출력은 없는데, 로직만 제어할꺼다.)
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("smart") && pw.equals("123")){
		response.sendRedirect("ex05LoginSuccess.jsp?id="+id);
	}else{
		response.sendRedirect("ex05LoginFail.jsp");
	}
	
	%>

</body>
</html>