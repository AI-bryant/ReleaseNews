package commons.basicServlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 新闻发布项目的公共父类Servlet
 */
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 获取session对象 */
	protected HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	
	/** 获取servletContext对象 */
	public ServletContext getServletContext(HttpServletRequest request){
		return this.getServletContext();
	}
}
