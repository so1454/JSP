<%@ page errorPage = "ex05Error.jsp" %>
<!-- errorPage : 해당하는 파일에 문제가 발생했을때 띄워줄 페이지를 지정 -->

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!-- page지시자 : JSP 페이지 내부의 전체적인 환경설정을 담당 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  java Exception 파트 열어서 봐보기! -->
	<%= 2/0  %>
	
	
	<% 
	// JSP에서 객체를 생성할 때는 자동완성 사용하기!!!
	// --> 자동완성해야 import 구문이 자동으로 생성된다!
	
	ArrayList<String> list = new ArrayList<>();  
	
	%>
	<!-- 
		1) 지시자(Directive) :   
			>> web container가 JSP를 Servlet class로 변환할때 
			필요한 정보를 기술하기 위해 사용함.
			
			 꺽쇠 퍼센트 + page 가 오면 page지시자
			옆에 오는거에 따라서 	~지시자 라고 불림
			
			page 지시자
			tagelib 지시자
			include 지시자
	-->







</body>
</html>