package train1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

        public class LoginServlet extends HttpServlet{	 
	    public void doPost(HttpServletRequest request,HttpServletResponse response )
		throws ServletException ,IOException{
	    response.setContentType("text/html;charset=utf8");
	    PrintWriter out=response.getWriter();
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    if(username!=null &&username.trim().equals("admin")&& 
	    		password!=null && password.trim().equals("123")){
	    //登录成功
	    	response.sendRedirect("welcome.html");//请求重定向
	    }else{
	    	out.println("账号密码错误，3秒后跳转到登录页面");
	    	response.setHeader("refresh", "3;login.html");  }
}
	    
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException ,IOException{
		doPost(request,response);
	}
	
	}
