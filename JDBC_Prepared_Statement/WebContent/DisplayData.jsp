<%@page import="com.model.DBconnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Data</title>
<style type="text/css">
	table,tr,td,th{
		border: 1px solid black;
		border-collapse: collapse;
		padding: 10px;
	}
</style>
</head>
<body>


<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Birth Date</th>
		<th>Gender</th>
		<th>Hobbies</th>
		<th>Languages Know</th>
		<th>Edit Data</th>
	</tr>
	
<% 
	Dao d = new Dao();
	ResultSet rs = d.select();
	
	while(rs.next()){
	
%>
		
	
	<tr>		
		<td><%= rs.getString("fname") %></td>
		<td><%= rs.getString("lname") %></td>
		<td><%= rs.getInt("age") %></td>
		<td><%= rs.getLong("phone") %></td>
		<td><%= rs.getString("email") %></td>
		<td><%= rs.getDate("birthdate") %></td>
		<td><%= rs.getString("gender") %></td>
		<td><%= rs.getString("hobbies") %></td>
		<td><%= rs.getString("languages") %></td>
		<td>
			<form action="EditData.jsp" method="post">
				<input type="hidden" name="userID" value="<%= rs.getInt("id") %>" >
				<button>Edit</button>
			</form>
			<form action="delete_db" method="post">
				<input type="hidden" name="userID" value="<%= rs.getInt("id") %>" >
				<button>Delete</button>
			</form>
		</td>
	</tr>
	
	<% }
	rs.close();
	DBconnection.CloseConnection();
	%>
</table>

<a href="./form.jsp" >Back To Form Page</a>
</body>
</html>