package RequestParamsServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response )
			throws ServletException ,IOException{
		 response.setContentType("text/html;charset=utf-8");
		 request.setCharacterEncoding("utf8");
		 PrintWriter out=response.getWriter();
		String username=  request.getParameter("username");
		String password= request.getParameter("password");
		System.out.println("”√ªß√˚£∫"+username);
		System.out.println("√‹¬Î£∫"+password);
		out.println("admin:"+username);
		out.println("password:"+password);
	    String[] hobby=request.getParameterValues("hobby");
	    out.println("hobby:");
	    
	    for(int i=0;i<hobby.length;i++){
	    	out.print(hobby[i]+",");
	    
	    }
}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException ,IOException{
		doPost(request,response);
	}
}
