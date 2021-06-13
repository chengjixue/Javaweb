package chain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AntiTheft extends HttpServlet{
     public void doGet(HttpServletRequest request,HttpServletResponse response)
     throws ServletException ,IOException{
    	 response.setContentType("text/html;charset=utf-8");
    	 PrintWriter out = response.getWriter();
    	 String referer =request .getHeader("referer");
    	 System.out.println(referer);
    	 String sitePart ="http://"+request.getServerName();
    	 System.out.println(sitePart);
    	 System.out.println(referer!=null && referer.startsWith(sitePart));
    	 if (referer!=null && referer.startsWith(sitePart)){
    		 out.println("dealing download.....");
    	 }else{
    		 RequestDispatcher re =request.getRequestDispatcher("/download.html");
    		 re.forward(request, response);
    		 
    	 }
     }
     public void doPost(HttpServletRequest request,HttpServletResponse response)
    	     throws ServletException ,IOException{
    	 doGet(request,response);
     }
	
	
	
}
