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
		connDB connDB = new connDB();
		String op = request.getParameter("op");
		if (op != null && op.equals("listPerson")) {
			ResultSet rs = null;
			List<person> personList = new ArrayList<person>();
			try {
				String sql = "select * from person";
				rs = connDB.doQuery(sql);
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
				connDB.closeConnection();
			}
			request.setAttribute("personList", personList);
			request.getRequestDispatcher("/listPerson.jsp").forward(request, response);
		}
		// 按照name来删除
		if (op != null && op.equals("deletePerson")) {
			String name = request.getParameter("name");
			try {
				String sql = "delete from person where name='" + name + "'";
				System.out.println(sql);
				int num = connDB.doUpdate(sql);
				System.out.println("num" + num);
				response.sendRedirect(request.getContextPath() + "/personServlet?op=listPerson");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connDB.closeConnection();
			}
		}
		// 新增person
		if (op != null && op.equals("addPerson")) {
			try {
				String sql = "insert into person(name,age) values('王宏',12)";
				int num = connDB.doUpdate(sql);
				response.sendRedirect(request.getContextPath() + "/personServlet?op=listPerson");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connDB.closeConnection();
			}
		}
		//修改
		if (op != null && op.equals("updatePerson")) {
			try {
				String name=request.getParameter("name");
				String sql = "update person set age=18 where name='"+name+"'";
				int num = connDB.doUpdate(sql);
				response.sendRedirect(request.getContextPath() + "/personServlet?op=listPerson");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				connDB.closeConnection();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
