<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 0. 한글 인코딩 잡아주기
		request.setCharacterEncoding("UTF-8");
		
		// 1. 요청받은 데이터 꺼내오기 (request - String으로 밖에 못받음)
		String name = request.getParameter("name");
		String Java = request.getParameter("Java");
		String Web = request.getParameter("Web");
		String IOT = request.getParameter("IOT");
		String ANDROID = request.getParameter("ANDROID");
		
		// 2. 숫자로 변환해주기
		// 이런식으로 많이 쓰기도 한다고!(위아래 합해서)
		// int java1 = Integer.parseInt(request.getParameter("Java"));
		
		int java1 = Integer.parseInt(Java);
		int web1 = Integer.parseInt(Web);
		int iot1 = Integer.parseInt(IOT);
		int android1 = Integer.parseInt(ANDROID);
		
		
		// 3.평균구하기
		int avg = (java1 + web1 + iot1 + android1)/4 ;
		
		// 4-1. 담을 변수지정해주기
		String score = "";
		String text = "";
		
		// 4-2. 평균에 따른 학점 구해주기
		// 100~95 : A+ / ~90 : A / ~85 :B+ / ~80 :B / ~ :F
		
		if (avg >= 95 && avg <= 100){
			score = "A+";
			text = "축하합니다 ✨✨";
		}else if (avg >= 90 && avg < 95) {
			score = "A";
			text = "축하합니다 ✨✨";
		}else if( avg >= 85 && avg <90) {
			score = "B+";
			text = "최고에요 ✨✨";
		}else if (avg >= 80 && avg < 85){
			score = "B";
			text = "최고에요 ✨✨";
		}else{
			score = "F";
			text = "분발하세요";
		}
		
		
	%>

<form action="ex03Request.jsp" method="post">
	
	<!-- fieldset은 테두리를 만들어준다 / lengend는 테두리의 제목을 만들어줌 -->
	<fieldset>
		<legend> 학점관리 프로그램 </legend>
	
			<table align ="center">
	
				<tr>
					<td>이름</td>
					<td><%=name%></td>
				
				</tr>
				
				<tr>
					<td>Java점수 </td>
					<td><%=java1%></td>
				</tr>
				
				<tr>
					<td>Web점수</td>
					<td> <%=web1%></td>
				</tr>
				
				<tr>
					<td>IOT점수 </td>
					<td><%=iot1%></td>
				</tr>
				
				<tr>
					<td>ANDROID점수 </td>
					<td><%=android1%></td>
				</tr>
				<tr>
					<td>평균점수 </td>
					<td><%=avg%></td>
				</tr>
				<tr>
					<td>학점 </td>
					<td><strong> <%=score%></strong></td>
				</tr>
				<tr>
					<td><strong> <%=text%></strong></td>
				</tr>
			
	
			</table>
		</fieldset>
	</form>

</body>
</html>