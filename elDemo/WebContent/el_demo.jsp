<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8" import="Demo.person,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf8">
<title>el表达式</title>
</head>
<body>
	<h2>
		${pageContext.response.characterEncoding}<br>
		<%
			String name = "admin";
			session.setAttribute("name", name);
			application.setAttribute("player.name", "张三");

			person p = new person("tom", 11);
			request.setAttribute("person", p);

			List<String> list = new ArrayList<String>();
			list.add("李四");
			list.add("王五");
			request.setAttribute("list", list);
		%>
		<%-- 获取变量值--%>
		${name}<br> ${sessionScope.name}<br>
		<%-- 获取变量名包含特殊字符--%>
		运动员：${applicationScope["player.name"] }<br>
		<%-- 获取对象中的属性--%>
		${person.name}<br> ${person.age}<br>
		<%-- 获取数组中的属性--%>
		${list }<br> ${list[0] }<br>

	</h2>
</body>
</html>