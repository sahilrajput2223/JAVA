<!DOCTYPE html>
<html  xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>

<div align="center">

	<h1>Edit User</h1>
	
	<br>
	<form action="#" th:action="@{/updateUser}" th:object="${editUser}" method="post">
	User Id: <input type="text" th:field="*{id}" readonly="readonly">
	username: <input type="text" th:field="*{username}">
	email: <input type="email" th:field="*{email}">
	address: <input type="text" th:field="*{address}">
	<input type="submit" value="Save">
	</form>
	
</div>
</body>
</html>