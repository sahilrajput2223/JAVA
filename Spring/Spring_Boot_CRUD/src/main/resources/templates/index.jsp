<!DOCTYPE html >

<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" >
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>

<div align="center"> 
	<h1>User Management</h1>
	<a href="/newUser">New User</a>
	<br>
	<table border=1 cellpadding = 10>
		<tr>
			<th>User Id</th>
			<th>Username</th>
			<th>Email</th>
			<th>Address</th>
			<th>Action</th>
		</tr>
		
		<tr th:each="user : ${allUser}"> 
			<td th:text="${user.id}">User Id</td>
			<td th:text="${user.username}">Username</td>
			<td th:text="${user.email}">Email</td>
			<td th:text="${user.address}">Address</td>
			<td>
				
				<a th:href="@{'/edit/'+${user.id}}">Edit</a>
				<a th:href="@{'/delete/'+${user.id}}">Delete</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>