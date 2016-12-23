package check.guochao.jdbc;
import java.sql.*;;
public class jdbcDemo {
	public static void main(String args[]) {
	    try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	     System.out.println("Success loading Mysql Driver!");
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/test","root","root");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

	      System.out.println("Success connect Mysql server!");
	      Statement stmt = connect.createStatement();
	     // String sql = "insert into usr (uname,upwd) values('张学友','123456')";//编写sql语句，生效。
	      String sql = "delete from usr where uid in(9);";// 删除id在（）中的记录
	     // String sql = "create table jtest()";
	      stmt.execute(sql);
	      ResultSet rs = stmt.executeQuery("select * from usr");
	     
	      
	                                                              //usr 为你表的名称
	while (rs.next()) {
	        System.out.println(rs.getString("uname"));
	      }
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
	  }
	}

