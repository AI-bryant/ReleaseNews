package A_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import B_Service.ViewNewsService;
import commons.basicServlet.BasicServlet;
import entity.entityBean.AboutUs;

public class MVAboListServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String ABOUTLIST_LIST = "aboutusList.jsp";
	private ViewNewsService service = null;
	private RequestDispatcher requestJump = null;
	
	public void init() {
        this.service= new ViewNewsService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AboutUs> aboutUsList = this.service.getAboutUsList();
		request.setAttribute("aboutUsList", aboutUsList);
		this.requestJump = request.getRequestDispatcher(ABOUTLIST_LIST);
		this.requestJump.forward(request, response);
	}
}
