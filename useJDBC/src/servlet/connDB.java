package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connDB {
	Connection conn = null;//数据库链接类
	Statement stmt = null;//执行sql
	ResultSet rs = null;//保存查询结果
	
	// mysql 5.7及以下
	private static String dbDriver = "com.mysql.jdbc.Driver";// 数据库驱动
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/javawebdb?characterEncoding=UTF-8";// 数据库服务器地址
	private static String username = "root";// mysql账号
	private static String password = "root";// mysql密码
	
	// mysql8及以下
	// String dbDriver="com.mysql.cj.jdbc.Driver";
	// String
	// dbUrl="jdbc:mysql://127.0.0.1:3306/javawebdb?serverTimezone=GMT%2B8&useSSL=false";
	
	
	//链接数据库
	public static Connection getConnection(){
		Connection conn=null;
		try {// 1.注册数据库驱动
			Class.forName(dbDriver);
			// 2.数据库的链接
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}if(conn==null){
			System.out.println("数据库链接失效");
		}
		return conn;	
	}
	//执行查询
	public ResultSet doQuery(String sql){
		try {
			conn=connDB.getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);//执行select
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	//执行新增，修改，删除，
	public int doUpdate(String sql){
		int result=0;
		try {
			conn=connDB.getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			result=stmt.executeUpdate(sql);//执行update
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//关闭数据库
	public void closeConnection(){
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
			
}
