package count;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet {
	private int number = 0;

	synchronized void countpeople() {
		number++;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		if (session.isNew()) {// ��������ͳ��
			countpeople();
			session.setAttribute("count", number);
		}
		int count = 0;
		if (session.getAttribute("count") != null) {
			count = (int) session.getAttribute("count");
		}
	out.println("���ǵ�"+count+"��������վ����");
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException ,IOException{
		doPost(request,response);
	}
	
}