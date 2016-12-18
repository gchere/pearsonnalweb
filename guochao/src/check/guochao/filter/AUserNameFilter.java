package check.guochao.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;


/**
 * Servlet Filter implementation class PswordFilter
 */
@WebFilter(urlPatterns="/servlet/Check",dispatcherTypes={
		DispatcherType.REQUEST,
		DispatcherType.INCLUDE,
		DispatcherType.FORWARD,
		DispatcherType.ERROR
		
})
public class AUserNameFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AUserNameFilter() {
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
		String password = request.getParameter("uname");
		if (password !=null && !"".equals(password)) {
			
			chain.doFilter(request, response);
			
		} else {
			HttpServletResponse hr= (HttpServletResponse)response;
			hr.sendRedirect("/guochao/filter/UnameLost.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("UserNameFilter过滤器正在启动。。。");
	}

}
