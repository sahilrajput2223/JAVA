<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>Search Result</h2>
		
	<table border=1 cellpadding="10">
		<tr>
			<th>id</th>
			<th>username</th>
			<th>email</th>
			<th>address</th>
		</tr>
		
		<c:forEach items="${resultUserData}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.address}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>