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
import java.sql.*;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("uname");
		String passWord = request.getParameter("upass");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Mysql Driver!");
		} catch (ClassNotFoundException e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			System.out.println("Success connect Mysql server!");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from usr");
			while (rs.next()) {
				String test_name = rs.getString("uname");
				String test_pwd = rs.getString("upwd");
				if (test_name==name && test_pwd==passWord) {
					HttpSession session = request.getSession();
					session.setAttribute("userid", name);
					ServletContext context = getServletContext();
					RequestDispatcher rd = context.getRequestDispatcher("/jsp/welcome.jsp");
					rd.forward(request, response);
					 return ; 
				} else {
					ServletContext context = getServletContext();
					RequestDispatcher rd = context.getRequestDispatcher("/jsp/errorlogin.jsp");
					rd.forward(request, response);
					 return ; 
					/*
					 * response.setStatus(HttpServletResponse.
					 * SC_MOVED_PERMANENTLY); response.setHeader("location",
					 * "/guochao/index.jsp");
					 */
				}
			}

		} catch (SQLException e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
