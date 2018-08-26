package A_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.basicServlet.BasicServlet;
import entity.entityBean.BabyInfo;
import entity.entityBean.BabyMedical;
import B_Service.ViewBabyService;

public class MVBabyMedicalServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private static final String MEFICAL_LIST = "medicalRecords.jsp";
	private ViewBabyService service = null;
	private RequestDispatcher requestJump = null;
	
    public void init() {
    	this.service= new ViewBabyService();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BabyMedical> MedicalList = this.service.getMedicalList();
		if(MedicalList != null && MedicalList != null){
			request.setAttribute("MedicalList", MedicalList);
			this.requestJump = request.getRequestDispatcher(MEFICAL_LIST);
			this.requestJump.forward(request, response);
		}else{
			response.sendRedirect(MEFICAL_LIST);
		}
	}
}