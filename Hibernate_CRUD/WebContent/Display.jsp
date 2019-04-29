<%@page import="java.util.ArrayList"%>
<%@page import="VO.Student"%>
<%@page import="java.util.List"%>
<%@page import="model.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display || Hibernate</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>Id...</th>
			<th>UserName...</th>
			<th>Email...</th>
			<th>Phone...</th>
			<th>Action...</th>
		</tr>
		<%
		Dao d = new Dao();
		List list  = new ArrayList();
		list  = d.display();
		session.setAttribute("list",list);
	%>
		
	 <c:forEach items="${sessionScope.list}" var="i">
			
		<tr>
			<td>${i.sid}</td>
			<td>${i.username}</td>
			<td>${i.email}</td>
			<td>${i.phone}</td>
			<td>
				<a href="edit.jsp?id=${i.sid}" >Edit</a> &nbsp;
				<a href="delete_DB?id=${i.sid}" >Delete</a>
			</td>
		</tr>
		
	</c:forEach>
	
	<% session.removeAttribute("list"); %>	
	</table>
	
	<a href="form.jsp">Click To Go Form (Insert data) Page </a>
	
</body>
</html>