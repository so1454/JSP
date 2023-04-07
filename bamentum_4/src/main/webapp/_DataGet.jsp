<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="shortcut icon" href="#">
</head>
<body>

name : <p id="name"></p>
age : <h3 id="age"></h3>
birth : <input type="text" id="birth">
<br><br>
<button type="button">클릭</button>

<script src="https://code.jquery.com/jquery-3.6.4.min.js" 
    integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" 
    crossorigin="anonymous"></script>    

<script type="text/javascript">
$(document).ready(function (){
	$("button").click(function(){
		$.ajax({
			url : "_Data.jsp",
			type : "get",
			success : function(data){
			//	alert('success');
			//	alert(data); // json이 아니다
				
				let json = JSON.parse(data); // String -> json
			//	alert(json); 
			
			// 데이터 가져오기	
				$("#name").text(json.name);
				$("#age").html(json.age);
				$("#birth").val(json.birth);
			},
			error : function() {
				alert('error');
			}
		});
	});
});
</script>
</body>
</html>