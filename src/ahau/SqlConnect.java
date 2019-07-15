package ahau;

import java.io.*;
import java.util.*;
import java.sql.*;

public class SqlConnect {
	public static void main(String[] args) {
	    Connection conn;
	    int num;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost/students?useSSL","root","123456");
	    	Statement stmt=conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from test where name='deo'");
//	        num=stmt.executeUpdate("insert into test(name,password) values('sunny2','yfy2')");
	        while(rs.next()) {
	        	System.out.println(rs.getString(1)+" ");
	        	System.out.println(rs.getString("password"));
	        }
	        
//	        if(num>0) {
//	        	System.out.println("插入成功");
//	        }else {
//	        	System.out.println("插入失败");
//	        }
	    }
	    catch(Exception e) {
	    	e.getStackTrace();
	    }
	}
	}


