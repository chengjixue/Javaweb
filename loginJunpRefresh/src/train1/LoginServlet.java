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
	    //��¼�ɹ�
	    	response.sendRedirect("welcome.html");//�����ض���
	    }else{
	    	out.println("�˺��������3�����ת����¼ҳ��");
	    	response.setHeader("refresh", "3;login.html");  }
}
	    
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException ,IOException{
		doPost(request,response);
	}
	
	}
