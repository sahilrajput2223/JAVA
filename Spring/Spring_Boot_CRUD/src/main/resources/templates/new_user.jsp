<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>

<div align="center">

	<h1>Create New User</h1>
	
	<br>
	
	<form action="#" th:action="@{/save}" th:object="${newUser}" method = "post">
		
	Username: <input type="text" th:field="*{username}">
	Email: <input type="email" th:field="*{email}">
	Address: <input type="text" th:field="*{address}">
	
	<input type="submit" value="Save">
	</form>
</div>

</body>
</html>