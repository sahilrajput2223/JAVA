<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>

<div align="center">
	<h2>Edit User</h2>
	
	
	<form:form method="post" action="updateUser" modelAttribute="newUser">
		
		<form:hidden path="id"/>
		username: <form:input path="username"/>
		email: <form:input path="email"/>
		address: <form:input path="address"/>
		
		<input type="submit" value="Submit">
	</form:form>
</div>
</body>
</html>