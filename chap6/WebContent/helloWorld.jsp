<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>随机数和随机大小写</title>
</head>
<body>
<% int a=10,b=20; %>
<%!public double randNum(){
	//生成10到0的随机数
	//math.rand生成0到1的随机数
	 return Math.random()*20+10;
}
public char randChar(){
	//生成a到z的随机字母        小写a到z：097-122
	return (char)('a'+Math.random()*('z'-'a'+1));
}
//随机生成大写a到z 
public char randChar2(){
	return (char)(Math.random()*26+65);
}
 %>
<%=randNum()%>
<br>
<%=randChar()%>
<br>
<%=randChar2()%>
</body>
</html>