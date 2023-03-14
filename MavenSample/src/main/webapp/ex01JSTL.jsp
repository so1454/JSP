<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- JSTL라이브러리 로드
	: Java Standard Tag Library
	: core 라이브러리 ? 변수를 선안, 조건문, 반복문 사용할 때 쓰는 도구 -->

<%@ page isELIgnored = "false" %>
<!-- Expression Language
	: jstl 사용해서, 스크립트릿 사용해서 만든 변수, 객체, 메소드의 값을 화면에 출력하고 싶을 때 사용 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 50번 반복하려면(스크립트릿은 구기술임 / JSTL로 가능하다) -->
	<c:forEach begin ="1" end = "50" step="2" var ="i">
	<h1> ${i} </h1>
	</c:forEach>









</body>
</html>