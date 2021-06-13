package servlet1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class personServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<person> personList = new ArrayList<person>();
		person person = new person();
		person p1 = new person("����", 8);
		person p2 = new person("����", 13);
		person p3 = new person("����", 15);
		person p4 = new person("Ӵ��", 17);
		person p5 = new person("����", 12);
		person p6 = new person("�绨", 10);
		 personList.add(p1);
		 personList.add(p2);
		 personList.add(p3);
		 personList.add(p4);
		 personList.add(p5);
		 personList.add(p6);
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			// mysql 5.7������
//			String dbDriver = "com.mysql.jdbc.Driver";// ���ݿ�����
//			String dbUrl = "jdbc:mysql://127.0.0.1:3306/javawebdb";// ���ݿ��������ַ
//			String username = "root";// mysql�˺�
//			String password = "root";// mysql����
//			// mysql8������
//			// String dbDriver="com.mysql.cj.jdbc.Driver";
//			// String
//			// dbUrl="jdbc:mysql://127.0.0.1:3306/javawebdb?serverTimezone=GMT%2B8&useSSL=false";
//
//			// 1.ע�����ݿ�����
//			Class.forName(dbDriver);
//
//			// 2.���ݿ������
//			 conn=DriverManager.getConnection(dbUrl, username, password);
//
//			// 3.��ȡStatement����
//			stmt = conn.createStatement();
//
//			// 4.ʹ��Statementִ��sql���
//			String sql = "select * from person";
//			rs = stmt.executeQuery(sql);// ִ�в�ѯ����ý����
//
//			// 5.����rs�����
//			while (rs.next()) {
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				person = new person(name, age);
//				personList.add(person);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// 6.�Ͽ������ͷ���Դ
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				rs = null;
//			}
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				stmt = null;
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				conn = null;
//			}
//		}
//	
		request.setAttribute("personList", personList);
		request.getRequestDispatcher("/listPerson.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
