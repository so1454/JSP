package ajax_con;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.tscm.model.BmtDAO;
import com.tscm.model.BmtPtDetailDTO;

public class AjaxDB2Service implements Command {
	private static final Logger LOG = LoggerFactory.getLogger(AjaxDB2Service.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOG.debug(" {} service - start ", "AjaxDB2Service");
		String moveURL = null;
		try {
			request.setCharacterEncoding("UTF-8");
			BmtDAO dao = new BmtDAO();
			List<BmtPtDetailDTO> listDto = dao.selectAllPost();
			
			if(listDto != null)
			{
				LOG.debug("AjaxDB2Service - listDto size {}", listDto.size());
				request.setAttribute("listPage", listDto);
			}
			else {
				LOG.debug("AjaxDB2Service - listDto null");
			}
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			LOG.debug(" {} req get id {}, pwd {} ", "AjaxDB2Service", id, pwd);

/*			
			String name = "성춘향";
			int age = 16;
			String birth = "09/03/12";

			String json = "{ \"id\":\"" + id + "\", \"pwd\":" + pwd + ", \"birth\":\"" + birth + "\" }"; 
			LOG.debug("AjaxDB2Service - json {}", json);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("json");
			response.getWriter().write(json);
			response.getWriter().close();
*/
			String gson = new Gson().toJson(listDto);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("json");
			response.getWriter().write(gson);
			response.getWriter().close();
			
			LOG.debug(" {} req get gson {} ", "AjaxDB2Service", gson);
			
			moveURL = "AjaxDBGet2.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(" exception : {} ", e);
			
		}
		
		return moveURL;
	} 
}
