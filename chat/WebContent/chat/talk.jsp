<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>
<form method=post>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="msg" size="40">
<input type="submit" value="·¢ËÍ">
</form>
<%
request.setCharacterEncoding("GB2312");
String msg=request.getParameter("msg");
String host=request.getRemoteAddr();
if(msg!=null && !msg.trim().equals("")){
	String chatwords=(String)application.getAttribute("chatwords");
	if(chatwords!=null){
		chatwords=chatwords+host+">>"+msg+"<br>";
	}else{
		chatwords=host+">>"+msg+"<br>";
	}
	application.setAttribute("chatwords", chatwords);
	msg=null;
}

%>
