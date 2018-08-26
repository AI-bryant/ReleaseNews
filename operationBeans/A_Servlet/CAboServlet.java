package A_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.entityBean.AboutUs;
import B_Service.EditNewsService;

public class CAboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX_PAGE = "VColServlet";
	private EditNewsService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new EditNewsService();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean createUs = this.service.doCreateAboutUs(this.getAboutUsEntity(request));
		if(createUs != true){
			this.requestJump = request.getRequestDispatcher(INDEX_PAGE);
			this.requestJump.forward(request, response);
		}else{
			response.sendRedirect(INDEX_PAGE);
		}
	}
	
	private AboutUs getAboutUsEntity(HttpServletRequest request){
		AboutUs us = new AboutUs();
		String aboutUsEmail = request.getParameter("aboutUsEmail");
		String aboutUsContext = request.getParameter("aboutUsContext");
		us.setAboutusContext(aboutUsContext);
		us.setAboutusEmail(aboutUsEmail);
		return us;
	}
}
