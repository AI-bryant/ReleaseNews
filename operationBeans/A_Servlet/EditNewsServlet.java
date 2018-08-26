package A_Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import B_Service.EditNewsService;
import entity.entityBean.News;

/**
 * Servlet implementation class EditRemarkServlet
 */
public class EditNewsServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
	private static final String RELEASE_ACTION = "MVUnNewsListServlet";
	private EditNewsService service = null;
	
	public void init() {
	    this.service= new EditNewsService();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String unNewsId = request.getParameter("unNewsId");
		if(unNewsId != null){
			News news = new News();
			news.setNewsId(Integer.parseInt(unNewsId));
			this.service.doReleaseNewsById(news);
		}
		response.sendRedirect(RELEASE_ACTION);
	}
}
