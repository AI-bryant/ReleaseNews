package A_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import B_Service.ViewNewsService;
import entity.entityBean.News;


public class VNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DETAIL_PAGE = "detail.jsp";
	private ViewNewsService service = null;
	private RequestDispatcher requestJump = null;
	
	public void init() {
	    this.service= new ViewNewsService();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News news = this.getNewsEntity(request);
		if(news != null){
			request.setAttribute("news", news);
		}
		this.requestJump = request.getRequestDispatcher(DETAIL_PAGE);
		this.requestJump.forward(request, response);
	}
	
	private News getNewsEntity(HttpServletRequest request){
		News tempNews = null;
		String newsId = request.getParameter("newsId");
		if(newsId != null && !newsId.trim().equals("")){
			tempNews = new News();
			tempNews.setNewsId(Integer.valueOf(newsId));
		}else{
			int newsId2 = (Integer) request.getAttribute("newsId");
			if(newsId2 != 0){
				tempNews = new News();
				tempNews.setNewsId(newsId2);
			}
		}
		return this.service.getNewsByContainListRemarkNewsId(tempNews);
	}
}
