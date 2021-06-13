package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//��¼����Servlet
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String op = request.getParameter("op");// ������������
		String loginName = request.getParameter("loginName");
		String loginPass = request.getParameter("loginPass");
		String auto=request.getParameter("auto");
		// ��¼����
		if (op != null && op.equals("login")) {
			if (loginName != null && !loginName.trim().equals("") && loginPass != null
					&& !loginPass.trim().equals("")) {
				if (loginName.trim().equals("admin") && loginPass.trim().equals("123")) {// ��¼admin��123���¼�ɹ�
					if (auto!=null && auto.trim().equals("auto")) {
						//����û�������ʹ���cookie��
						Cookie cookie=new Cookie("loginName",loginName);
						cookie.setMaxAge(60*60*24*10);//����ʱ��Ϊ10��
						response.addCookie(cookie);//���͵������
						Cookie cookie1=new Cookie("loginPass",loginPass);
						cookie1.setMaxAge(60*60*24*10);
						response.addCookie(cookie1);
					}
					session.setAttribute("loginName", loginName);
					// session.setAttribute(loginPass, "loginPass");
					response.sendRedirect("manager.jsp");
				} else {// �˺����������ת��¼ҳ��
					response.sendRedirect("login.jsp");
				}
				return;
			}
			//ͨ��cookieʵ���Զ���¼
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
				//�ж�cookies�����˺��Ƿ���ȷ
				if (auto!=null && auto.equals("auto") && loginName!=null && loginName.equals("admin") && loginPass!=null && loginPass.equals("123")) {
					System.out.println(loginName+loginPass);
					session.setAttribute("loginName", loginName);
					response.sendRedirect("manager.jsp");
				}else{
					response.sendRedirect("login.jsp");
				}
			}
		}
		// �˳���¼
		if (op != null & op.equals("logout")) {
			session.invalidate();// ���ٵ�ǰsession
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
 * req.getParameter("op");//������������
 * 
 * //��¼���� if(op != null && op.equals("login")) { if(loginName != null &&
 * !loginName.trim().equals("") && loginPass != null &&
 * !loginPass.trim().equals("")) { if(loginName.trim().equals("admin") &&
 * loginPass.trim().equals("123")) {//ģ���¼�˺���admin������123,
 * session.setAttribute("loginName", loginName);
 * resp.sendRedirect("manager.jsp"); }else {//�˺��������
 * resp.sendRedirect("login.jsp"); } } } //�˳�����
 * 
 * if(op != null && op.equals("logout")) { session.invalidate();// ���ٵ�ǰsession
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