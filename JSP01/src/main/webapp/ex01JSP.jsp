<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>HELLO</h1>
	<%-- 스크립트릿 주석
		JSP 구성요소
		1) 지시자(Directive) : <%@%>
			>> web container가 JSP를 Servlet class로 변환할때 
			필요한 정보를 기술하기 위해 사용함.
		2) 선언문(Declaration) : <%!%>
			>> java 코드를 작성할 수 있는 공간
		3) 스크립트릿(Scriptlet) : <%%>
			>> jsp 내부에 java 코드를 삽입하고 싶을 때 사용!!
			>> 어디에적어도 상관이 없음(body태그가 꼭 아니여도됨 근데, body태그 안에 넣는게 좋긴하대)
		4) 표현식(Expression) :<%=%>
			>> java 코드에서 작성한 변수, 객체 메소드 결과를 웹페이지에 출력하고 싶을 때 사용!!
			>> .java 변환 될때 out.print()라는 메소드가 실행!!
			>> 표현식을 적을때는 안쪽에 ;(세미콜론) 사용 금지!
 	--%>
	
	<%
		//자바코드를 쓸 수 있는 곳
	//1~ 10까지 h1태그 사용해서 출력해보기
	
	
	for (int i = 1 ; i <= 10 ; i++ ){%>
		<h1><%= i %></h1>  <!--안에 표현식으로 적어야 웹페이지에 출력이됨-->

	
	<%} %>
	







</body>
</html>