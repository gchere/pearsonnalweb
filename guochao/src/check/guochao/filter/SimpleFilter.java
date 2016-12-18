package check.guochao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class SimpleFilter
 */
@WebFilter(
		urlPatterns = { "" }, 
		initParams = { 
				@WebInitParam(name = "ref", value = "helloworld")
		})
public class SimpleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SimpleFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("***过滤器销毁。");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("***执行do方法之前。");
		chain.doFilter(request, response);
		System.out.println("***执行do方法之后。");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		String initParam = config.getInitParameter("ref");
		System.out.println("****过滤器初始化，初始化参数 = "+initParam);
	}

}
