package A_Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import B_Service.RegLogService;
import commons.basicServlet.BasicServlet;
import entity.entityBean.User;

public class LogServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX_PAGE = "VColServlet";
	private RegLogService service = null;
	
    public void init() {
        this.service= new RegLogService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userTemp = this.getUserEntity(request);
		User user = this.service.loginUser(userTemp);
		if(user != null){
			this.getSession(request).setAttribute("user", user);
			this.getSession(request).setAttribute("userId", user.getUserId());
			response.sendRedirect(INDEX_PAGE);
		}else{
			response.sendRedirect("reglog.jsp");
		}
	}
	
	private User getUserEntity(HttpServletRequest request){
		User user = null;
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		if((userName != null && !userName.trim().equals("")) || (userPass != null && !userPass.trim().equals(""))){
			user = new User();
			user.setUserName(userName);
			user.setUserPass(userPass);
		}
		return user;
	}
}
