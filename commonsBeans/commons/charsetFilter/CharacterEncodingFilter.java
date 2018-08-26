package commons.charsetFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	private String charSet = null;							//设置字符编码
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.charSet = fConfig.getInitParameter("charset");	//取得初始化参数
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.charSet);			//设置统一编码
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}
}
