package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.eclipse.jdt.internal.compiler.ast.LabeledStatement;

public class LastAccessServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		String lastAccessTime = null;
		// ͨ������cooki��ʵ��
		Cookie[] cookie = request.getCookies();
		for (int i = 0; cookie != null && i < cookie.length; i++) {
			if ("lastAccess".equals(cookie[i].getName())) {
				lastAccessTime = cookie[i].getValue();
				break;
			}
		}
		String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());// ��ǰʱ��
		currentTime = URLEncoder.encode(currentTime, "utf8");// cooki���ܱ���ո���Ҫ���±���
		if (lastAccessTime == null) {// ��һ����ʾ��ǰʱ�䣬������ʾ�ϴη���ʱ��
			out.println("�״η���ʱ��Ϊ��" + URLDecoder.decode(currentTime, "utf8") + "<br>");

		} else {
			out.println("�㵱ǰ�ķ���ʱ��Ϊ��" + URLDecoder.decode(currentTime, "utf8") + "<br>");
			out.println("���ϴεķ���ʱ��Ϊ��" + URLDecoder.decode(lastAccessTime, "utf8") + "<br>");
		}
		// ��һ����Ҫ����lastaccess
					Cookie lastTimeCookie = new Cookie("lastAccess", currentTime);
					lastTimeCookie.setMaxAge(60 * 60);
					response.addCookie(lastTimeCookie);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}