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
	<form method="get" action="search">
		<input type="text" name="keyword" required="required">
		<input type="submit" value="Search">
	</form>
	
	<br>
	<a href="newUser">New User</a>
	<br>
	<br>
	<table border=1  cellpadding="10">
			<tr>
				<th>Id</th>
				<th>Username</th>
				<th>Email</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${allUser}" var="user">
				<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.address}</td>
				<td>
					<a href="editUser?id=${user.id}">Edit</a>
					
					<a href="deleteUser?id=${user.id}">Delete</a>
				</td>
				</tr>
			</c:forEach>			
			
	</table>
</div>

	
</body>
</html>