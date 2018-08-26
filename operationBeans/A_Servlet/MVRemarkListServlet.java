package A_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import B_Service.ViewNewsService;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.User;

public class MVRemarkListServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String REMARK_LIST = "remarkList.jsp";
	private ViewNewsService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new ViewNewsService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Remark> remarkList = this.service.getListRemark();
		List<User> userList = this.service.getListUser();
		List<News> newsList = this.service.getNewsListByStatus(this.getNewsEntity());
		if(remarkList != null && userList != null){
			request.setAttribute("remarkList", remarkList);
			request.setAttribute("userList", userList);
			request.setAttribute("newsList", newsList);
			this.requestJump = request.getRequestDispatcher(REMARK_LIST);
			this.requestJump.forward(request, response);
		}else{
			response.sendRedirect(REMARK_LIST);
		}
	}
	
	private News getNewsEntity(){
		News newsTemp = new News();
		newsTemp.setNewsStatus(News.STATUS_RELEASE_SUCCESS);
		return newsTemp;
	}
}