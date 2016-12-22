package check.guochao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/servlet/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Success loading Mysql Driver!");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Success connect Mysql server!");
			String uname = request.getParameter("userName");
			String upwd = request.getParameter("userPwd");
			
			PreparedStatement statement=connection.prepareStatement("INSERT INTO usr VALUES(?,?)");
			statement.setString(1, uname);
			statement.setString(2, upwd);
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			 System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			 System.out.print("get data error!");
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
