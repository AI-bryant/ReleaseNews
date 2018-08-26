package A_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import B_Service.ViewBabyService;
import B_Service.ViewNewsService;

public class MVIndexCountServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String COUNT_LIST = "countIndex.jsp";
	private ViewNewsService service = null;
	private ViewBabyService babyService = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new ViewNewsService();
        this.babyService= new ViewBabyService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int countUser = this.service.getCountUser();
		int countRemark = this.service.getCountRemark();
		int countNews = this.service.getCountNews();
		int countAboutUs = this.service.getCountAboutUs();
		String month = request.getParameter("month");
		int averageFeed = this.babyService.getAverageFeed(month);
		request.setAttribute("countUser", countUser);
		request.setAttribute("countRemark", countRemark);
		request.setAttribute("countNews", countNews);
		request.setAttribute("countAboutUs", countAboutUs);
		request.setAttribute("averageFeed", averageFeed);
		this.requestJump = request.getRequestDispatcher(COUNT_LIST);
		this.requestJump.forward(request, response);
	}
}