<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
</head>
<body>

<div align="center">
	<h2>New User</h2>
	
	<form:form action="save" method="post" modelAttribute="user">
		Name: <form:input path="username"/>
		Email: <form:input path="email"/>
		Address: <form:input path="address"/>
		<input type="submit" value="Save User">
	</form:form>
</div>
</body>
</html>