package A_Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import B_Service.ViewBabyService;
import entity.entityBean.BabyInfo;

public class VBabyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BABY_INFO = "babyInfoList.jsp";
	private ViewBabyService service = null;
	private RequestDispatcher requestJump = null;
	
	public void init() {
	    this.service= new ViewBabyService();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BabyInfo> BabyList = this.service.getBabyList();
		if(BabyList != null && BabyList != null){
			request.setAttribute("BabyList", BabyList);
			this.requestJump = request.getRequestDispatcher(BABY_INFO);
			this.requestJump.forward(request, response);
		}else{
			response.sendRedirect(BABY_INFO);
		}
	}
}
