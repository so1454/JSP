package ajaxCommunication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxCon")
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Serv() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	
	//get 방식으로 통신할때의 함수!
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	// agax로 보낼 데이터의 한글 인코딩해주기(깨질 수 있음)
    	response.setContentType("application/x-json; charset=UTF-8");
        
        // ajax로 데이터를 전송하기 위한 메서드인 print import!
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String age = request.getParameter("age");    
        
        System.out.println("doget :"+name);
        System.out.println("doget :"+age);
           
        // 이런 방식으로 가공해서 ajax로 전송한다는 말이에요
        out.print("Get 통신 : 안녕 내 이름은 "+name+"이고 나이는 "+age+"란다"); //response    
    }

    
    // post 방식으로 통신할때의 함수
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("application/x-json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String age = request.getParameter("age");    
        
        System.out.println("doget :"+name);
        System.out.println("doget :"+age);
            
        out.println("Post통신 : 안녕 내 이름은 "+name+"이고 나이는 "+age+"란다"); //response
    }
    
    
    
    
    
    
    
    
    
    
    
}
