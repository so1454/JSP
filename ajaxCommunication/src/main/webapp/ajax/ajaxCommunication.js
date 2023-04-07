$(document).ready(function(){
    $('#ajaxConGetButton').click(function(){
        AjaxConGet();
    })
    
    $('#ajaxConPostButton').click(function(){
        AjaxConPost();
    })
    
})
/* 페이지가 로드되면 위에서 생성했던 두 개의 버튼에 대해 click 이벤트를 부여한다.*/ 
 
function AjaxConGet(){		/*get 방식으로 ajax와 통신을 시도하는 함수이다! */ 
    var url = "http://localhost:8080/test/ajaxCon";
    $.ajax({  
		/* 통신 방식과 통신할 url, 수신 할때의 데이터 타입, 서블릿으로 보낼 데이터 정보를 넣어준다. 
		dataType은 서블릿에서 객체 형식이나 두개 이상의 데이터를 송신할 경우 "json"을, 
		하나의 문장으로 송신할 경우 "html"을 넣어준다. 필자는 out.print()로 하나만 보내기 때문에 html로 해주었다.*/
		
        type:"GET",
        url:url,
        dataType:"html",
        data:{
            name : $('#ajaxConName').val(),
            age : $('#ajaxConAge').val()
        },
        
        /*Servlet과의 모든 통신이 정상적으로 끝나면 메서드의 매개변수 안에 Servlet이 
        response 한 데이터가 있게 된다. 이를 출력하기 위해 div태그에 응답 정보가 들어있는 textNode를 상속시키고, 
        이를 초기 HTML 코드로 생성했던 div 태그에 상속시킨다.*/
        success : function(data){
            alert('ajax GET 통신 성공');
            var $div = $('<div></div>');
            var text = document.createTextNode(data);
            $div.append(data);
            $div.appendTo($('#myDiv'))
        
        },
        /* Servlet과의 통신 실패 시 에러 코드 및 내용에 대한 세부사항을 출력시킨다. 
        만일 에러 코드가 200이 나올 경우 dataType에 대한 수정이 필요하다.*/
        error : function(request,status,error){
            alert('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error); //에러 상태에 대한 세부사항 출력
            alert(e);
        }
    })
    
}
 
 /*type을 GET에서 POST로만 변경한 코드이다.*/
function AjaxConPost(){
    var url = "http://localhost:8080/test/ajaxCon";
    $.ajax({
        type:"POST",
        url:url,
        dataType:"html",
        data:{
            name : $('#ajaxConName').val(),
            age : $('#ajaxConAge').val()
        },
        success : function(data){
            alert('ajax POST 통신 성공');
            var $div = $('<div></div>');
            var text = document.createTextNode(data);
            $div.append(data);
            $div.appendTo($('#myDiv'))
        },
        error : function(request,status,error){
            alert('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error); //에러 상태에 대한 세부사항 출력
            alert(e);
        }
    })
    
}
