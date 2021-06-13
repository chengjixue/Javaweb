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
		// 通过遍历cooki来实现
		Cookie[] cookie = request.getCookies();
		for (int i = 0; cookie != null && i < cookie.length; i++) {
			if ("lastAccess".equals(cookie[i].getName())) {
				lastAccessTime = cookie[i].getValue();
				break;
			}
		}
		String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());// 当前时间
		currentTime = URLEncoder.encode(currentTime, "utf8");// cooki不能保存空格，需要重新编码
		if (lastAccessTime == null) {// 第一次显示当前时间，不能显示上次访问时间
			out.println("首次访问时间为：" + URLDecoder.decode(currentTime, "utf8") + "<br>");

		} else {
			out.println("你当前的访问时间为：" + URLDecoder.decode(currentTime, "utf8") + "<br>");
			out.println("你上次的访问时间为：" + URLDecoder.decode(lastAccessTime, "utf8") + "<br>");
		}
		// 第一次需要保存lastaccess
					Cookie lastTimeCookie = new Cookie("lastAccess", currentTime);
					lastTimeCookie.setMaxAge(60 * 60);
					response.addCookie(lastTimeCookie);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}