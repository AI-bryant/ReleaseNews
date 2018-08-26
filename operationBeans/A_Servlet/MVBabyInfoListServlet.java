package A_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import entity.entityBean.BabyInfo;
import B_Service.ViewBabyService;

public class MVBabyInfoListServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String BABY_LIST = "babyInfoList.jsp";
	private ViewBabyService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
    	this.service= new ViewBabyService();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BabyInfo> BabyList = this.service.getBabyList();
		if(BabyList != null && BabyList != null){
			request.setAttribute("BabyList", BabyList);
			this.requestJump = request.getRequestDispatcher(BABY_LIST);
			this.requestJump.forward(request, response);
		}else{
			response.sendRedirect(BABY_LIST);
		}
	}
}