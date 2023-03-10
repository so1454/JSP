package Servlet01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. url mapping 값 지정하는 방법
// - url mapping 이란?
// : web browser에서 Servlet을 동작시켰을 때, 실제 클래스 이름 대신
// 		지정한 문자열을 url mapping(연결)하는 기법
//	--> 사용하는 이유
//		(1) 경로가 길어진다(클래스 명칭을쓰면) - 불편함
//		(2) 경로가 그대로 드러남 - 보안상 문제발생

@WebServlet("/Create")
public class ex00CreateServlet extends HttpServlet {
	// △△△△△ 모든 Servlet은 HttpServlet을 상속받는다! △△△△△
	// --> HttpServlet이 가지고 있는 메소드, 필드를 재사용 혹은 재정의하는 것이 가능하다.
	// --> HttpServlet은 apache, tomcat, servlet, container에서 제공해준다!
	
	
	// 2. 객체 직렬화 ID 
	// --> 해당하는 파일이 Servlet임을 알려주는 고유 ID값
	// 없어도 상관은 없는데, 0.00001% 확률로 안될때가 있음 그니까 그냥 두자!
	private static final long serialVersionUID = 1L;
       
	
	// 3. 생성자 : 객체 생성하는 순간에 호출되는 메소드
    // 한번만 호출됨
    public ex00CreateServlet() {
        super();		// --> 부모클래스의 생성자 호출
        System.out.println("생성자 호출!");
    }
    
    
    
    
    // 4. init(initialize)
    // 한번만 호출됨
    // 		: 초기화 / Servlet class에게 너는 이제부터 Servlet이야!! 라고 이야기 메소드
    //----------> servletness
    //		--> 초기 값을 설정하는 역할
    // * 객체를 생성하고, 초기값을 설정하는 기능은 메모리(자원,비용)를 많이 사용한다
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet 초기화 메소드 호출!");
	}
	
	
	
	
	
	// 5. destroy
	// 진행하다가 멈추면 이 친구가 호출이됨
	//	 : Servlet을 삭제하는 기능!(Sever를 종료하면 호출되는 메소드)
	public void destroy() {
		System.out.println("destroy 메소드 호출~");
	}


	
	
	
	// 6. service
	// 새로 고침하면 만들어져 있는 service 메소드가 계속 호출을함
	// : main method와 같은 역할!
	// : Client 요청을 처리해주는 메소드
	// ---> html코드 출력, 조건문, 반복문을 쓰는게 가능해짐, 로직을 작성하는 구간
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service 메소드 호출!");
	}
	
	
	
	
	// 7. goGet, doPost
	// -- > Client로 부터 요청을 받는 방식은 여러개!
	// 요청방식(get, post)에 따라서 다른 기능을 수행하고 싶을때 사용하는 메소드
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
