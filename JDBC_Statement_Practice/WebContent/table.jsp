<!--  in this page all the data from the DataBase is displayed  -->
<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.dao"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
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
			dao d = new dao();
			ResultSet rs = d.selectUser();
			
			while(rs.next()){	
		%>
		
	
	<tr>		
		<td><%= rs.getString(2) %></td>
		<td><%= rs.getString(3) %></td>
		<td><%= rs.getInt(4)  %></td>
		<td><%= rs.getLong(5) %></td>
		<td><%= rs.getString(6) %></td>
		<td><%= rs.getString(7) %></td>
		<td><%= rs.getString(8) %></td>
		<td><%= rs.getString(9) %></td>
		<td><%= rs.getString(10) %></td>
		<td> <form action="EditForm.jsp" method="POST" > 
				<input type="hidden" name="getIdFromTable" value="<%= rs.getShort("id") %>" >
			 	
			 	<button>Edit</button> 
			 </form>
			 <form action="DeleteData" method="POST" > 
				<input type="hidden" name="getIdFromTableToDelete" value="<%= rs.getShort("id") %>" >
			 	
			 	<button>Delete</button> 
			 </form>
		</td>
	</tr>
	
	<%
		}
		rs.close();
	%>
</table>

<a href="./form.jsp" >Back To Form Page</a>
</body>
</html>