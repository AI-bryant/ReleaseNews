package A_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.entityBean.Column;
import entity.entityBean.News;
import B_Service.ViewNewsService;

public class VTheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_PAGE = "list.jsp";
	private ViewNewsService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new ViewNewsService();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Column> columnList = this.service.getListColumn();
		Column column = this.getColumnEntity(request);
		if(columnList != null){
			request.setAttribute("columnList", columnList);
		}else{
			response.sendRedirect(LIST_PAGE);
		}
		
		if(column != null){
			request.setAttribute("column", column);
			long newPage = column.getNewsCount();
			if(newPage % 10 == 0){
				request.setAttribute("newsPage", Integer.valueOf(column.getNewsCount()/10));
			}else{
				request.setAttribute("newsPage", Integer.valueOf(column.getNewsCount()/10)+1);
			}
		}
		this.requestJump = request.getRequestDispatcher(LIST_PAGE);
		this.requestJump.forward(request, response);
	}
	
	private Column getColumnEntity(HttpServletRequest request){
		News news = null;
		String columnId = request.getParameter("columnId");
		String pageNum = request.getParameter("pageNum");
		if(columnId != null){
			news = new News();
			news.setColumnId(Integer.valueOf(columnId));
			if(pageNum != null){
				news.setPage(Integer.valueOf(pageNum));
				news.setNewsStatus(News.STATUS_RELEASE_SUCCESS);
				request.setAttribute("pageNum", pageNum);
			}else{
				news.setPage(0);
				news.setNewsStatus(News.STATUS_RELEASE_SUCCESS);
				request.setAttribute("pageNum", 1);
			}
		}
		return this.service.getColumnContainListNewsIdByColumnId(news);
	}
}
