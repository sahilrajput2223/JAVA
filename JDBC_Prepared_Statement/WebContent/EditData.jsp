<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Data</title>

 <style type="text/css">
 	form{
 	padding: 100px;
 	}
 	fieldset{
 	margin-top: 2%;
 	margin-left: 35%;
 	height: 410px;
 	padding: 20px;
 	width: 275px;
 	}
 	button{
 	height: 100%;
 	width: 100%;
 	}
 </style>
 
</head>
<body>


<%

	int userID =Integer.parseInt(request.getParameter("userID")); 
	application.setAttribute("user_ID",userID);
	Dao d =  new Dao();
	ResultSet resultSet = d.selectById(userID);
	
	while(resultSet.next()){
		
		String temp1 = resultSet.getString("hobbies");
		String temp2 = resultSet.getString("languages");
		
		String hobbie[] = temp1.split(",");
		String language[] = temp2.split(",");
		
		int h_len = hobbie.length;
		int l_len = language.length;
		
		
	
%>
<form action="update_db" method="POST">
	<fieldset>
		<legend>Registration Page</legend>

		<table>
			<tr>
				<td><label>First Name: </label></td>
				<td><input type="text" name="fname" 
					value="<%= resultSet.getString("fname")%>"></td>
			</tr>

			<tr>
				<td><label>Last Name: </label></td>
				<td><input type="text" name="lname"
					 value="<%= resultSet.getString("lname") %>" ></td>
			</tr>

			<tr>
				<td><label>Age: </label></td>
				<td><input type="text" name="age" value="<%= resultSet.getInt("age") %>"></td>
			</tr>

			<tr>
			<td><label>Phone No: </label></td>
			<td><input type="text" name="phone" value="<%= resultSet.getLong("phone") %>" ></td>
			</tr>
		
			<tr>
			<td><label>Email: </label></td>
			<td><input type="email" name="email" value="<%= resultSet.getString("email") %>" ></td>
			</tr>
	
			<tr>
			<td><label>Birth Date: </label></td>
			<td><input type="date" name="birthdate" value="<%= resultSet.getDate("birthdate") %>" ></td>
			</tr> 
	
			<tr>
			<td><label>Gender: </label></td>
			<td><input type="radio" name="gender" <% if(resultSet.getString("gender").equalsIgnoreCase("male")){ out.print("checked"); } %>   value="male">
			<label>:Male</label>
			<input type="radio" name="gender" <% if(resultSet.getString("gender").equalsIgnoreCase("female")){ out.print("checked"); } %> value="female">
			<label>:Female</label></td>
			</tr>
			
			<tr>
			<td valign="top"><label>Hobbies: </label></td>
			<td><input name="hobbie" type="checkbox" <% for(int i = 0 ; i < h_len ; i++){ if(hobbie[i].equalsIgnoreCase("Games")){ out.print("checked"); } }  %> value="Games" >:Games<br>
				<input name="hobbie" type="checkbox" <% for(int i = 0 ; i < h_len ; i++){ if(hobbie[i].equalsIgnoreCase("Coding")){ out.print("checked"); } }  %> value="Coding" >:Coding<br>
				<input name="hobbie" type="checkbox" <% for(int i = 0 ; i < h_len ; i++){ if(hobbie[i].equalsIgnoreCase("Music")){ out.print("checked"); } }  %> value="Music" >:Music<br>
				<input name="hobbie" type="checkbox" <% for(int i = 0 ; i < h_len ; i++){ if(hobbie[i].equalsIgnoreCase("Painting")){ out.print("checked"); } }  %> value="Painting" >:Painting<br></td>
			</tr>
			
			<tr>
			<td valign="top"> <label>Languages Know: </label></td>
			<td><input name="language" type="checkbox" <% for(int j = 0 ; j < l_len ; j++ ){ if(language[j].equalsIgnoreCase("php")){ out.println("checked"); } } %> value="php" >: PHP <br>
				<input name="language" type="checkbox" <% for(int j = 0 ; j < l_len ; j++ ){ if(language[j].equalsIgnoreCase("asp.net")){ out.println("checked"); } } %> value="asp.net" >: ASP.NET <br>
				<input name="language" type="checkbox" <% for(int j = 0 ; j < l_len ; j++ ){ if(language[j].equalsIgnoreCase("python")){ out.println("checked"); } } %> value="python" >: Python <br>
				<input name="language" type="checkbox" <% for(int j = 0 ; j < l_len ; j++ ){ if(language[j].equalsIgnoreCase("java")){ out.println("checked"); } } %> value="java" >: JAVA <br>
				<input name="language" type="checkbox" <% for(int j = 0 ; j < l_len ; j++ ){ if(language[j].equalsIgnoreCase("android")){ out.println("checked"); } } %> value="android" >: Android <br></td>
			</tr>
			
			<tr>
			 <td colspan="2" > <button title="Click To Submit" style="background-color: green; border: 1px solid green;" name="btnSubmit" >Submit</button> </td>
			</tr>
				
		</table>
	</fieldset>
	
</form>
<% } %>
</body>
</html>