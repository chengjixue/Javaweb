<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"  import="java.util.*,servlet.*,org.apache.commons.beanutils.BeanUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>person信息</title>
</head>
<body>
		<center>
			<h2>所有person信息</h2>
			<table width="50%" border="1">
				<tr>
					<td>序号</td>
					<td>姓名</td>
					<td>年龄</td>
					<td>操作</td>
					</tr>
					<c:forEach var="person" items="${personList}" varStatus="status">
					<tr>
					<td>${status.count}</td>
					<td>${person.name}</td>
					<td>${person.age}
					<c:if test="${person.age<=12}">岁是儿童</c:if>
					<c:if test="${person.age>12}">岁是少年</c:if>
					<c:if test="${person.age>18}">岁是成年</c:if>
					</td>
					<td>
					<a href="${pageContext.request.contextPath}/personServlet?op=updatePerson&name=${person.name}"
					onclick="if(confirm('确定要修改嘛')) return true;else return false">修改</a>
					<a href="${pageContext.request.contextPath}/personServlet?op=deletePerson&name=${person.name}"
					onclick="if(confirm('确定要删除嘛')) return true;else return false">删除</a>
					</td>
					</tr>
					</c:forEach>
			</table>
			总计有<c:out value="${personList.size()}"/>条信息 &nbsp; 
			<a href="${pageContext.request.contextPath}/personServlet?op=addPerson">添加</a>
		</center>
</body>
</html>