package A_Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.entityBean.AboutUs;
import entity.entityBean.BabyInfo;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.User;
import B_Service.DeleNewsService;

/**
 * Servlet implementation class OperaterDeleteServlet
 */
public class MDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleNewsService service = null;
	
    public void init() {
        this.service= new DeleNewsService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsId = request.getParameter("newsId");
		if(newsId != null){
			News news = new News();
			news.setNewsId(Integer.parseInt(newsId));
			this.service.deleteNewsById(news);
			response.sendRedirect("MVNewsListServlet");
		}
		
		String unNewsId = request.getParameter("unNewsId");
		if(unNewsId != null){
			News news = new News();
			news.setNewsId(Integer.parseInt(unNewsId));
			this.service.deleteNewsById(news);
			response.sendRedirect("MVUnNewsListServlet");
		}
		
		String userId = request.getParameter("userId");
		if(userId != null){
			User user = new User();
			user.setUserId(Integer.parseInt(userId));
			this.service.deleteUserById(user);
			response.sendRedirect("MVUserListServlet");
		}
		
		String remarkId = request.getParameter("remarkId");
		if(remarkId != null){
			Remark remark = new Remark();
			remark.setRemarkId(Integer.parseInt(remarkId));
			this.service.deleteRemarkById(remark);
			response.sendRedirect("MVRemarkListServlet");
		}
		
		String aboutUsId = request.getParameter("aboutUsId");
		if(aboutUsId != null){
			AboutUs aboutUs = new AboutUs();
			aboutUs.setAboutusId(Integer.parseInt(aboutUsId));
			this.service.deleteAboutUsById(aboutUs);
			response.sendRedirect("MVAboListServlet");
		}
		
		String babyId = request.getParameter("babyId");
		if(babyId != null){
			BabyInfo babyInfo = new BabyInfo();
			babyInfo.setBABY_INFO_ID(Integer.parseInt(babyId));
			this.service.deleteBabyInfoById(babyInfo);
			response.sendRedirect("MVBabyInfoListServlet");
		}
	}
}
