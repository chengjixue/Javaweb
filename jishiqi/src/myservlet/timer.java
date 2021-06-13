package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class timer extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response )
	throws ServletException ,IOException{
    	response.setContentType("text/html;charset=utf8");
    	PrintWriter out =response.getWriter();
    	out.println("<html><head><title>计时器</title></head>");
    	out.println("<body> <h3> 当前时间：");
    	out.println(new Date().toLocaleString());
    	response.setHeader("refresh", "1");
    	out.println("</h3></body></html>");
        out.flush();
    	//response.setHeader("Refresh","15,URL=https:baidu.com");
    	
    }
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException ,IOException{
		doGet(request,response);
	}
}
