package A_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;

import B_Service.ViewNewsService;
import entity.entityBean.Column;
import entity.entityBean.News;

public class MVUnNewsListServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String NEWS_LIST = "unnewsList.jsp";
	private ViewNewsService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new ViewNewsService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<News> newsList = this.service.getNewsListByStatus(this.getNewsEntity());
		List<Column> columnList = this.service.getListColumn();
		if(newsList != null && columnList != null){
			request.setAttribute("newsList", newsList);
			request.setAttribute("columnList", columnList);
			this.requestJump = request.getRequestDispatcher(NEWS_LIST);
			this.requestJump.forward(request, response);
		}else{
			response.sendRedirect(NEWS_LIST);
		}
	}
	
	private News getNewsEntity(){
		News newsTemp = new News();
		newsTemp.setNewsStatus(News.STATUS_RELEASE_SUBMIT);
		return newsTemp;
	}
}