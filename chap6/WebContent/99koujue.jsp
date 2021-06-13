<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>乘法口诀</title>
</head>
<body>
<%! String str="还记得这些口诀吗"; %>
<%=str %>
<br>
<%
	for (int i = 1; i < 10; i++) {
		for (int y = 1; y <= i; y++) {
			out.print(i + "*" + y + "=" + i * y + "  ");
		}
		out.println("<br>");
	}
%>
</body>
</html>