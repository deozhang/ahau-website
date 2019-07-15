package ahau;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DealServlet
 */
@WebServlet("/DealServlet")
public class DealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Connection conn;
		Statement stmt;
		ResultSet rs;
		
		try {
			int num;
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useSSL=false","root","123456");
			stmt=conn.createStatement();
			String sqlstr = "select * from userTable where name='"+request.getParameter("username")+"'";
//			String sqlstr = "select * from userTable where name='张三'";
			rs=stmt.executeQuery(sqlstr);
			if(rs.next()) {
				System.out.println("111");
			}else {
				rs.close();
				stmt.close();
				conn.close();
				System.out.println("222");
				out.println("<script type\"text/javascript\">alert(\"sb\");window.location.href=\"register.html\"</script>");
			}
		}catch(Exception e) {
			e.getStackTrace();
		}finally{
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
