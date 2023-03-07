<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("name");
		String Java = request.getParameter("Java");
		String Web = request.getParameter("Web");
		String IOT = request.getParameter("IOT");
		String ANDROID = request.getParameter("ANDROID");
		
		int java1 = Integer.parseInt(Java);
		int web1 = Integer.parseInt(Web);
		int iot1 = Integer.parseInt(IOT);
		int android1 = Integer.parseInt(ANDROID);
		
		int avg = (java1 + web1 + iot1 + android1)/4 ;
		
		String score = "";
		String text = "";
		
		if (avg >= 95 && avg <= 100){
			score = "A+";
			text = "축하합니다 ✨✨";
		}else if (avg >= 90 && avg < 95) {
			score = "A";
			text = "축하합니다 ✨✨";
		}else if( avg >= 85 && avg <90) {
			score = "B+";
			text = "축하합니다 ✨✨";
		}else if (avg >= 80 && avg < 85){
			score = "B";
			text = "축하합니다 ✨✨";
		}else{
			score = "F";
			text = "분발하세요";
		}
		
		
	%>
	<h1> <%=name%>님의 평균은 <%=avg%>이며, 학점은 <%=score%> 입니다 </h1>	
	<h1> <%=name%>님! <%=score%>학점 <%=text%> </h1>



</body>
</html>