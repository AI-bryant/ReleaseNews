package A_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import B_Service.EditNewsService;
import entity.entityBean.News;

public class MVNewsEditServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String NEWS_LIST_ACTION = "MVNewsListServlet";
	private EditNewsService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new EditNewsService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News newsTemp = this.getNewsEntity(request);
		if(newsTemp != null){
			this.service.doCreateNewsByColumnId(newsTemp);
			this.requestJump = request.getRequestDispatcher(NEWS_LIST_ACTION);
			this.requestJump.forward(request, response);
		}
	}
	
	private News getNewsEntity(HttpServletRequest request){
		News tempNews = null;
		int userId = 0;
		if(this.getSession(request).getAttribute("userId")!=null){
			userId = (Integer) this.getSession(request).getAttribute("userId");
		}
		String columnId = request.getParameter("columnId");
		String newsTitle = request.getParameter("newsTitle");
		String newsContext = request.getParameter("newsContent");
		if(newsTitle != null && !newsTitle.trim().equals("")){
			tempNews = new News();
			tempNews.setColumnId(Integer.valueOf(columnId));
			tempNews.setUserId(userId);
			tempNews.setNewsTitle(newsTitle);
			tempNews.setNewsContext(newsContext);
			tempNews.setNewsStatus(News.STATUS_RELEASE_SUBMIT);
		}
		return tempNews;
	}
}
