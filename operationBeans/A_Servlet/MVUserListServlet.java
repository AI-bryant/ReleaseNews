package A_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import B_Service.ViewNewsService;
import entity.entityBean.User;

public class MVUserListServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String USER_LIST = "userList.jsp";
	private ViewNewsService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new ViewNewsService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> userList = this.service.getListUser();
		if(userList != null && userList != null){
			request.setAttribute("userList", userList);
			this.requestJump = request.getRequestDispatcher(USER_LIST);
			this.requestJump.forward(request, response);
		}else{
			response.sendRedirect(USER_LIST);
		}
	}
}