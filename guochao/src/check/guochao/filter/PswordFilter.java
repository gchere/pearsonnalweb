package check.guochao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class PswordFilter
 */
@WebFilter("/servlet/Check")
public class PswordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PswordFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String password = request.getParameter("upass");
		if (password !=null && !"".equals(password)) {
			
			chain.doFilter(request, response);
			
		} else {
			HttpServletResponse hr= (HttpServletResponse)response;
			hr.sendRedirect("/guochao/filter/pswordLost.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("PswordFilter过滤器正在启动。。。");
	}

}
