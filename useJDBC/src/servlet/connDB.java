package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connDB {
	Connection conn = null;//���ݿ�������
	Statement stmt = null;//ִ��sql
	ResultSet rs = null;//�����ѯ���
	
	// mysql 5.7������
	private static String dbDriver = "com.mysql.jdbc.Driver";// ���ݿ�����
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/javawebdb?characterEncoding=UTF-8";// ���ݿ��������ַ
	private static String username = "root";// mysql�˺�
	private static String password = "root";// mysql����
	
	// mysql8������
	// String dbDriver="com.mysql.cj.jdbc.Driver";
	// String
	// dbUrl="jdbc:mysql://127.0.0.1:3306/javawebdb?serverTimezone=GMT%2B8&useSSL=false";
	
	
	//�������ݿ�
	public static Connection getConnection(){
		Connection conn=null;
		try {// 1.ע�����ݿ�����
			Class.forName(dbDriver);
			// 2.���ݿ������
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}if(conn==null){
			System.out.println("���ݿ�����ʧЧ");
		}
		return conn;	
	}
	//ִ�в�ѯ
	public ResultSet doQuery(String sql){
		try {
			conn=connDB.getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);//ִ��select
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	//ִ���������޸ģ�ɾ����
	public int doUpdate(String sql){
		int result=0;
		try {
			conn=connDB.getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			result=stmt.executeUpdate(sql);//ִ��update
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//�ر����ݿ�
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
