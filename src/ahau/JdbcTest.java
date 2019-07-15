package ahau;

import java.io.*;
import java.util.*;
import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
    	Connection conn;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		conn=DriverManager.getConnection("jdbc:mysql://localhost/student?useSSL=false","root","123456");
    		System.out.println("test");
    		if(conn!=null) {
    			System.out.println("连接成功!!!");
    			conn.close();
    		}else {
    			System.out.println("连接不成功!!!");
    		}
    	}catch(Exception e) {
    		e.getStackTrace();
    	}
    }
}
