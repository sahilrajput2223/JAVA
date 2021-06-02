<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>
<div align="center">
	<h1>User Management</h1>
	
	<form action="search" method="get">
		<input type="text" name="searchKey" required="required">
		<input type="submit" value="Submit"> 
	</form>
	
	<br>
	<a href="new">New User</a>
	<br>
	<table border=1 cellpadding="10">
		<tr>
			<th>id</th>
			<th>username</th>
			<th>email</th>
			<th>address</th>
			<th>action</th>
		</tr>	
		
		<c:forEach items="${allUser}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.address}</td>
				<td>
					<a href="edit?id=${user.id}">Edit</a>
					<a href="delete?id=${user.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</div>
</body>
</html>