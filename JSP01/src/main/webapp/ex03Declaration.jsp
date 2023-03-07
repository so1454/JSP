<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body  align = "center">
	
	<!--  2) 선언문(Declaration) : <%!%>   -->
	  <%= addNum(4,7) %>
				<!--표현식 풀어쓰면 out.print(addNum(4,7)); -->

		<%!
		// 선언문
		// java 코드를 작성할 수 있는 공간
		// 변수, 메소드 선언하고 싶을때 사용!
		// --> 선언하게 되는 변수, 메소드는 전역변수, 전역 메소드
		
		
		private int addNum(int num1, int num2){
			
			return num1 + num2;
		}
	
		%>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>