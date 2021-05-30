<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
	<h2>Edit User</h2>
	
	<form:form action="save" method="post" modelAttribute="user">
		
		ID: ${user.id} <form:hidden path="id"/>
		Name: <form:input path="username"/>
		Email: <form:input path="email"/>
		Address: <form:input path="address"/>
		<input type="submit" value="Save User">
	</form:form>
</div>


</body>
</html>