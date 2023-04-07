package com.tscm.controller;

import java.io.PrintWriter;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.tscm.model.BmtDAO;
import com.tscm.model.BmtPtDetailDTO;

public class AjaxDBService implements Command {
	private static final Logger LOG = LoggerFactory.getLogger(AjaxDBService.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOG.debug(" {} service - start ", "AjaxDBService");
		String moveURL = null;
		try {
			request.setCharacterEncoding("UTF-8");
			BmtDAO dao = new BmtDAO();
			List<BmtPtDetailDTO> listDto = dao.selectAllPost();
			
			if(listDto != null)
			{
				LOG.debug("AjaxDBService - listDto size {}", listDto.size());
				request.setAttribute("listPage", listDto);
			}
			else {
				LOG.debug("AjaxDBService - listDto null");
			}
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			LOG.debug(" {} req get id {}, pwd {} ", "AjaxDBService", id, pwd);

//			response.reset();
//			response.flushBuffer();
//			response.resetBuffer();
			
			String strToAjax = id + "hellow" + pwd;
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			response.getWriter().write(strToAjax);
			response.getWriter().close();
			
//			PrintWriter out = response.getWriter();
//			
//			out.println("<!DOCTYPE html>"); 
//			out.println("<body>"); 
//			out.println("</body>"); 
//			out.close();
			
			
			
			
			
//			String name = "성춘향";
//			int age = 16;
//			String birth = "09/03/12";
//
//			String json = "{ \"name\":\"" + name + "\", \"age\":" + age + ", \"birth\":\"" + birth + "\" }"; 
//			response.getWriter().print(json);
//			response.getWriter().write(json);
//			LOG.debug("AjaxDBService - json {}", json);
//			
//			PrintWriter out = response.getWriter();
//			out.print((String)"값을 받았다.");
//			
//			String name = "성춘향";
//			String gson = new Gson().toJson(name);
//			response.getWriter().write(gson);
//			response.getWriter().print(gson);
//			response.getWriter().flush();
//			LOG.debug("AjaxDBService - gson {}", gson);
			
			// 문자열 전송
		//	jobj.put("str", str);			
			
//			String name = "성춘향";
//			int age = 16;
//			String birth = "09/03/12";
//			
//			String json = "{ \"name\":\"" + name + "\", \"age\":" + age + ", \"birth\":\"" + birth + "\" }"; 
//			
//			response.getWriter().write(json);
//			
//			LOG.debug("AjaxDBService - json {}", json);
			
			
			moveURL = "AjaxDBGet.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(" exception : {} ", e);
			
		}
		
		return moveURL;
	} 
}
