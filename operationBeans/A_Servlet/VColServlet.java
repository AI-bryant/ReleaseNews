package A_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import B_Service.ViewNewsService;
import commons.basicServlet.BasicServlet;
import entity.entityBean.Column;
import entity.entityBean.News;

public class VColServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX_PAGE = "index.jsp";
	private ViewNewsService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new ViewNewsService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Column> columnList = this.service.getListColumn();
		List<News> newsList = this.getNewsList();
		
		if(columnList != null){
			request.setAttribute("columnList", columnList);
			request.setAttribute("newsList", newsList);
			this.requestJump = request.getRequestDispatcher(INDEX_PAGE);
			this.requestJump.forward(request, response);
		}else{
			response.sendRedirect(INDEX_PAGE);
		}
	}
	
	public List<News> getNewsList(){
		News news = new News();
		news.setNewsStatus(News.STATUS_RELEASE_SUCCESS);
		return this.service.getNewsListByStatus(news);
	}
}
