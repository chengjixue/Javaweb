<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>useBean</title>
</head>
<body>
<jsp:useBean id="personBean" class="Demo.person"/>
<%
personBean.setName("张三");
personBean.setAge(11);
%>
姓名：<%=personBean.getName() %><br>
年龄：<%=personBean.getAge() %>
</body>
</html>