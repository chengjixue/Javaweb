<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8" errorPage="errPage.jsp"  import="java.util.Date"%>
     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>page指令案例</title>
</head>
<body>
<% 
out.print((new Date()).toLocaleString());
String s="123";
int i=Integer.parseInt(s);
out.print("<br>i="+i);
%>
</body>
</html>