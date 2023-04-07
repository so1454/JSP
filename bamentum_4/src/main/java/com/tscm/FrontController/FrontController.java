package com.tscm.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tscm.controller.AjaxDB2Service;
import com.tscm.controller.AjaxDBService;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(FrontController.class);

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug(" {} service - start ", "FrontController");
		String moveURL = null;

		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String path = request.getContextPath();

		// 3. 1~2번을 활용하여 필요한 요청 이름 확인!
		String strUriDo = uri.substring(path.length() + 1);

		LOG.debug("uri {}, path {}, substr : {}", uri, path, strUriDo);
		if (strUriDo.equals("AjaxDB.do")) {
			AjaxDBService ajax_db = new AjaxDBService();
			moveURL = ajax_db.execute(request, response);
			LOG.debug("FrontController AjaxDBService moveURL {} ", moveURL);
			
		} else if (strUriDo.equals("AjaxDB2.do")) {
			AjaxDB2Service ajax_db = new AjaxDB2Service();
			moveURL = ajax_db.execute(request, response);
			LOG.debug("FrontController AjaxDB2Service moveURL {} ", moveURL);
			
		} else {
			LOG.debug("FrontController : {}", "잘못된 요청값");
		}

		RequestDispatcher rd =  request.getRequestDispatcher(moveURL);
		rd.forward(request, response);
		
		return;
		
	}

}
