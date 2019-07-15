package ahau;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		int num;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useSSL=false","root","12345678");
			stmt=conn.createStatement();
//			String sqlstr = "select * from userTable where name='"+request.getParameter("username")+"'";
			String sqlstr = "";

			rs=stmt.executeQuery(sqlstr);
			if(rs.next()) {
				out.println("<script type\"text/javascript\">alert(\"注册成功\");window.location.href=\"login.html\"</script>");
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
