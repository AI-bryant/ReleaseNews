package A_Servlet;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import B_Service.ViewBabyService;
import entity.entityBean.BabyInfo;

public class MVBabyInfoEditServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String BABY_LIST_ACTION = "MVBabyInfoListServlet";
	private ViewBabyService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
        this.service= new ViewBabyService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BabyInfo babyInfo;
		try {
			babyInfo = this.getNewsEntity(request);
			if(babyInfo != null){
				this.service.doCreateBabyInfo(babyInfo);
				this.requestJump = request.getRequestDispatcher(BABY_LIST_ACTION);
				this.requestJump.forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private BabyInfo getNewsEntity(HttpServletRequest request) throws ParseException{
		BabyInfo babyInfo = null;
		int userId;
		if(this.getSession(request).getAttribute("userId")!=null){
			userId = (Integer) this.getSession(request).getAttribute("userId");
		}
		//Date date = null;
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String date1 = request.getParameter("date");
		java.util.Date dates = null;
		dates = format1.parse(date1);
		java.sql.Date date = new java.sql.Date(dates.getTime()); 
		System.out.println(date);
		String eats = request.getParameter("eat");
		int eat = Integer.parseInt(eats);
		String sleeps = request.getParameter("sleep");
		/*if(sleeps!=null){
			Time sleep=new Time(sdf.parse(sleeps).getTime());
		}*/
		int excretion = Integer.parseInt(request.getParameter("excretion"));
		babyInfo = new BabyInfo();
		babyInfo.setDATA(date);
		babyInfo.setEAT(eat);
		babyInfo.setEXCRETION(excretion);
		babyInfo.setSLEEP(new Time(excretion));
		return babyInfo;
	}
}
