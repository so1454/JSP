<%@page import="com.smhrd.controller.contentSearch"%>
<%@page import="com.smhrd.model.contentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "./styles/content.css">
</head>
<body>
	<!-- 
				contents안에 담긴 객체(일단 예시)
				content_index: 영화
				title : 영화제목
				genre : 장르
				year : 방송년도
				stove : 시놉시스
				c_score : 평점
				age_class : 방송 연령 등급
	
			 -->

	<div id="movie-content-container">
		<div id="movie-title">영화</div>
	</div>
	<!-- contentDTO-> Object down casting 필수 -->
	<% List<contentDTO> contents= (List<contentDTO>)session.getAttribute("contents"); %>
	<div id="movie-image">
		<% for (int i=0; i<contents.size(); i++) {%>
		<img src="./netflix_img/<%=contents.get(i).getTitle()%>.jpg"/><%=contents.get(i).getTitle()%>
		<%if(i/5==0) {%>
		<br>
		<%}%>
		<%}; %>
	</div>
</body>
</html>