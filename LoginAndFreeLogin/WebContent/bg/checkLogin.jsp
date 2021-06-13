<%@page import="javax.websocket.SendResult"%>
<%
if(session.getAttribute("loginName")==null){
	response.sendRedirect("relogin.jsp");
}
 %>

