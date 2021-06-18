package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

public class personServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charest=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// mysql 5.7������
		String dbDriver = "com.mysql.jdbc.Driver";// ���ݿ�����
		String dbUrl = "jdbc:mysql://127.0.0.1:3306/javawebdb?characterEncoding=UTF-8";// ���ݿ��������ַ
		String username = "root";// mysql�˺�
		String password = "root";// mysql����
		// �������ݲ���ѯ
		String op = request.getParameter("op");
		// ��ѯ����
		if (op != null && op.equals("listPerson")) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			List<person> personList = new ArrayList<person>();
			try {
				// mysql8������
				// String dbDriver="com.mysql.cj.jdbc.Driver";
				// String
				// dbUrl="jdbc:mysql://127.0.0.1:3306/javawebdb?serverTimezone=GMT%2B8&useSSL=false";
				// 1.ע�����ݿ�����
				Class.forName(dbDriver);
				// 2.���ݿ������
				conn = DriverManager.getConnection(dbUrl, username, password);
				// 3.��ȡStatement����
				stmt = conn.createStatement();
				// 4.ʹ��Statementִ��sql���
				String sql = "select * from person";
				rs = stmt.executeQuery(sql);// ִ�в�ѯ����ý����
				// 5.����rs�����
				while (rs.next()) {
					person person = new person();
					String name = rs.getString("name");
					int age = rs.getInt("age");
					person = new person(name, age);
					personList.add(person);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 6.�Ͽ������ͷ���Դ
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
			request.setAttribute("personList", personList);
			request.getRequestDispatcher("/listPerson.jsp").forward(request, response);
		}
		// ����name��ɾ��
		if (op != null && op.equals("deletePerson")) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String name = request.getParameter("name");
			try {
				// 1.ע�����ݿ�����
				Class.forName(dbDriver);
				// 2.���ݿ������
				conn = DriverManager.getConnection(dbUrl, username, password);
				// 3.��ȡStatement����
				stmt = conn.createStatement();
				// 4.ʹ��Statementִ��sql���
				String sql = "delete from person where name='" + name + "'";
				System.out.println(sql);
				int num = stmt.executeUpdate(sql);
				System.out.println("num" + num);
				response.sendRedirect(request.getContextPath() + "/personServlet?op=listPerson");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
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
		// ����person
		if (op != null && op.equals("addPerson")) {
			Connection conn = null;
			Statement stmt = null;
			PreparedStatement perStmt = null;
			try {
				// 1.ע�����ݿ�����
				Class.forName(dbDriver);
				// 2.���ݿ������
				conn = DriverManager.getConnection(dbUrl, username, password);
				// 3.��ȡStatement����
				stmt = conn.createStatement();
				// 4.ʹ��Statementִ��sql���
				String sql = "insert into person(name,age) values('����',12)";
				int num = stmt.executeUpdate(sql);
				// 5.����ִ�н��
				response.sendRedirect(request.getContextPath() + "/personServlet?op=listPerson");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			
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
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
