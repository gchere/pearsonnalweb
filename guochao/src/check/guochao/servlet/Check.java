package check.guochao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Check
 */
@WebServlet("/servlet/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		String passWord=request.getParameter("upass");
		if("guochao".equals(name)&&"123456".equals(passWord)){
			HttpSession session=request.getSession();
			session.setAttribute("userid", name);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		}else {
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/errorlogin.jsp");
			rd.forward(request, response);
			/*response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			response.setHeader("location", "/guochao/index.jsp");*/
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
