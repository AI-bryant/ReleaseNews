package A_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import B_Service.EditNewsService;
import entity.entityBean.Remark;

/**
 * Servlet implementation class EditRemarkServlet
 */
public class EditRemarkServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
	private static final String DETAIL_PAGE = "VNewServlet";
	private EditNewsService service = null;
	private RequestDispatcher requestJump = null;
	
	public void init() {
	    this.service= new EditNewsService();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Remark remark = this.getNewsEntity(request);
		if(remark != null){
			this.service.doCreateRmearkByNewsId(remark);
			request.setAttribute("newsId", remark.getUserId());
			this.requestJump = request.getRequestDispatcher(DETAIL_PAGE);
			this.requestJump.forward(request, response);
		}
	}
	
	private Remark getNewsEntity(HttpServletRequest request){
		Remark tempRemark = null;
		String newsId = request.getParameter("newsId");
		String remarkContext = request.getParameter("remarkContext");
		Integer userId = (Integer) this.getSession(request).getAttribute("userId");
		if(newsId != null && !newsId.trim().equals("")){
			tempRemark = new Remark();
			tempRemark.setNewsId(Integer.valueOf(newsId));
			tempRemark.setRemarkContext(remarkContext);
			tempRemark.setUserId(userId);
		}
		return tempRemark;
	}
}
