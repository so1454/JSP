<%@page import="java.util.ArrayList"%>
<%@page import="com.smhrd.model.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!-- 1.request영역에 저장된 정보를 가져오시오. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="EUC-KR" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">
	<%
		// request에 있는 list 데이터 꺼내오기
		ArrayList<MemberDTO> list =(ArrayList)request.getAttribute("list");
		
	%>
	
	
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel </td>
								<td>Address </td>							
							</tr>
							<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
							<!-- 데이터가 존재하는 한 계속해서 반복적(for문)으로 내용을 꺼내올 수 있는 구조 만들기! -->
							 
							 <!-- 첫번째 방법 
							 
		                     for( MemberDTO dto :list ){
		                     <tr>
		                        <td>Email  dto.getEmail() </td>
		                        <td>Tel   dto.getTel()  </td>
		                        <td>Address   dto.getAddress() </td>                     
		                     </tr>
		                        }
								-->	
							
							<%
							for( int i = 0; i < list.size() ; i++ ){%>
							<tr>
								<td>Email  <%= list.get(i).getEmail() %></td>
								<td>Tel <%= list.get(i).getTel() %></td>
								<td>Address <%= list.get(i).getAddress() %></td>							
							</tr>
								<%}%>
							
							
						
						</table>
					</nav>		
					<a href="main.jsp" class="button next scrolly">되돌아가기</a>	
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

