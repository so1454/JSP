
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.tscm.model.BmtPtDetailDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="org.slf4j.Logger"%>
<%@ page import="org.slf4j.LoggerFactory"%>
    
<!DOCTYPE html>
<html>
<head>

	<link rel="shortcut icon" href="#">
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js" 
		integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" 
		crossorigin="anonymous">
	</script>

</head>

<body>


	<%
		Logger LOG = LoggerFactory.getLogger(getClass());
	
		LOG.debug(" page Start : {} ", "AjaxDBGet.jsp");
		
		List<BmtPtDetailDTO> listDto = (List)request.getAttribute("listPage");;
		
		if(listDto != null)
		{
			LOG.debug("AjaxDBGet.jsp - listDto size {} ", listDto.size());
			for(int i=0; i< listDto.size(); i++)
			{
				LOG.debug("AjaxDBGet.jsp - {} : {} ", 
						i, listDto.get(i).getP_content());
			}
			
		}
		else {
			LOG.debug("AjaxDBGet.jsp - listDto null ");
		}
		
	%>
	
	<h2> Ajax 통신 </h2>
	
	name : <input type="text" id="name"/> 
	<br>
	age  : <input type="text" id="age"/>
	<br><br>
	<button type="button" id="btnGet">ajaxGet</button>
	<button type="button" id="btnPost">ajaxPost</button>
	
	<br><br>
	
	<div id = "myDiv"> div test </div>
	<div id = "divTable"></div>

	<script type="text/javascript">
		
		
		$('#btnGet').click(function(){
			$.ajax({
				
				type : "get",
				url : "AjaxDB2.do",
				data : {id:"abc", pwd:"456"},
				dataType:"text",
				
				success : function(data, textStatus, jqXHR){
					console.log('success');
					console.log(this.url);
					console.log('data :' + data);
					console.log('textStatus :' + textStatus);
					console.log('jqXHR : ' + jqXHR);

					//자바스크립트 배열변수 선언
						
					let $div=$('<div></div>');
					let text = document.createTextNode(data);
					$div.append(data);
					$div.appendTo($('#myDiv'));
					
				},
				error : function(errorMsg) {
					console.log('error');
					console.log(errorMsg);
				}
			});
		});
		
		let post_send = {id:"aggg", pwd:"7987789"};

		$('#btnPost').click(function(){
			$.ajax({
				type : "post",
				url : "AjaxDB2.do",
				data : post_send,
				dataType:"json",
				
				success : function(receive_data){
					console.log('success');
					console.log(receive_data);
					
					let json = receive_data;
					console.log(json);
					
					for(let i=0; i< json.length; i++) {
						let $div=$('<div></div>');
						$div.append(json[i].postId);
						$div.append(' : ');
						$div.append(json[i].p_content);
						$div.append('<br>');
						$div.appendTo($('#myDiv'));
					}
					
				},
				error : function(errorMsg) {
					console.log('error');
					console.log(errorMsg);
				}
			});
		});

		console.log("javascript finish");
		
	</script>
</body>

</html>