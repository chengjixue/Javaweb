package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录处理Servlet
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String op = request.getParameter("op");// 操作处理类型
		String loginName = request.getParameter("loginName");
		String loginPass = request.getParameter("loginPass");
		String auto=request.getParameter("auto");
		// 登录处理
		if (op != null && op.equals("login")) {
			if (loginName != null && !loginName.trim().equals("") && loginPass != null
					&& !loginPass.trim().equals("")) {
				if (loginName.trim().equals("admin") && loginPass.trim().equals("123")) {// 登录admin何123则登录成功
					if (auto!=null && auto.trim().equals("auto")) {
						//如果用户点击，就存入cookie中
						Cookie cookie=new Cookie("loginName",loginName);
						cookie.setMaxAge(60*60*24*10);//生存时间为10天
						response.addCookie(cookie);//发送到浏览器
						Cookie cookie1=new Cookie("loginPass",loginPass);
						cookie1.setMaxAge(60*60*24*10);
						response.addCookie(cookie1);
					}
					session.setAttribute("loginName", loginName);
					// session.setAttribute(loginPass, "loginPass");
					response.sendRedirect("manager.jsp");
				} else {// 账号密码错误，跳转登录页面
					response.sendRedirect("login.jsp");
				}
				return;
			}
			//通过cookie实现自动登录
			Cookie[] cookies=request.getCookies();
			if(cookies!=null){
				for(Cookie cookie : cookies){
					if (cookie.getName().equals("loginName")) {
						loginName=cookie.getValue();
					}else if(cookie.getName().equals("loginPass")){
						loginPass=cookie.getValue();
					}
				}
				System.out.println(auto+" 2 "+loginName+" 3 "+loginPass);
				System.out.println(auto!=null && auto.equals("auto"));
				
				System.out.println(loginName!=null && loginName.equals("admin"));
				System.out.println(loginPass!=null && loginPass.equals("123"));
				//判断cookies保存账号是否正确
				if (auto!=null && auto.equals("auto") && loginName!=null && loginName.equals("admin") && loginPass!=null && loginPass.equals("123")) {
					System.out.println(loginName+loginPass);
					session.setAttribute("loginName", loginName);
					response.sendRedirect("manager.jsp");
				}else{
					response.sendRedirect("login.jsp");
				}
			}
		}
		// 退出登录
		if (op != null & op.equals("logout")) {
			session.invalidate();// 销毁当前session
			response.sendRedirect("login.jsp");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
/*
 * import java.io.IOException; import java.io.PrintWriter;
 * 
 * import javax.servlet.ServletException; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * public class LoginServlet extends HttpServlet{
 * 
 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * resp.setContentType("text/html;charset=utf-8"); PrintWriter
 * out=resp.getWriter(); HttpSession session=req.getSession(true);
 * if(session.isNew()) { String loginName = req.getParameter("loginName");
 * String loginPass = req.getParameter("loginPass"); String op =
 * req.getParameter("op");//操作处理类型
 * 
 * //登录处理 if(op != null && op.equals("login")) { if(loginName != null &&
 * !loginName.trim().equals("") && loginPass != null &&
 * !loginPass.trim().equals("")) { if(loginName.trim().equals("admin") &&
 * loginPass.trim().equals("123")) {//模拟登录账号是admin密码是123,
 * session.setAttribute("loginName", loginName);
 * resp.sendRedirect("manager.jsp"); }else {//账号密码错误
 * resp.sendRedirect("login.jsp"); } } } //退出处理
 * 
 * if(op != null && op.equals("logout")) { session.invalidate();// 销毁当前session
 * resp.sendRedirect("login.jsp"); } }
 * 
 * }
 * 
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { doGet(request,response);
 * 
 * } }
 */