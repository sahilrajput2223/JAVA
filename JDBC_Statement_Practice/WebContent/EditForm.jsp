<%@page import="java.sql.ResultSet"%>
<%@page import="model.dao"%>

<%

	dao dao = new dao();
	int Uid = Integer.parseInt(request.getParameter("getIdFromTable"));
	application.setAttribute("idForSubmitData",Uid);
	//int Uid = Integer.parseInt(application.getAttribute("idForSetData").toString());
	
	ResultSet rs = dao.selectbyId(Uid);
	
	while(rs.next())
	{
	
	String temp1 = rs.getString("Hobbie");
	String temp2 = rs.getString("Language");
	
	String hobbie[] = temp1.split(",");
	String language[] = temp2.split(",");
	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>

<style type="text/css">
form {
	padding: 100px;
}

fieldset {
	margin-top: 2%;
	margin-left: 35%;
	height: 400px;
	padding: 20px;
	width: 275px;
}

button {
	height: 100%;
	width: 100%;
}
</style>


</head>
<body>
	<form action="EditData" method="POST">
		<fieldset>
			<legend>Registration Page</legend>

			<table>
				<tr>
					<td><label>First Name: </label></td>
					<td><input type="text" name="fname" value="<% out.print(rs.getString("Fname")); %>"
						placeholder="Enter First Name"></td>
				</tr>
								<tr>
					<td><label>Last Name: </label></td>
					<td><input type="text" name="lname" value="<%= rs.getString("Lname") %>"
						placeholder="Enter Last Name"></td>
				</tr>

				<tr>
					<td><label>Age: </label></td>
					<td><input type="text" value="<%= rs.getInt("Age") %>" name="age" placeholder="Enter Age"></td>
				</tr>

				<tr>
					<td><label>Phone No: </label></td>
					<td><input type="text" value="<%= rs.getLong("Phone") %>" name="phone"
						placeholder="Enter Phone No"></td>
				</tr>

				<tr>
					<td><label>Email: </label></td>
					<td><input type="email" value="<%= rs.getString("Email") %>" name="email"
						placeholder="Enter Email "></td>
				</tr>

				<tr>
					<td><label>Birth Date: </label></td>
					<td><input type="date" value="<%= rs.getString("Birthdate") %>" name="birthdate"
						placeholder="Enter Birth Date"></td>
				</tr>

 			<tr>
					<td><label>Gender: </label></td>
					<td>
						<input type="radio" name="gender" <% if( rs.getString("Gender").equalsIgnoreCase("male")){ out.print("checked"); } %> value="male"> 
							<label>:Male</label>
						<input type="radio" name="gender" <% if( rs.getString("Gender").equalsIgnoreCase("female")){ out.print("checked"); } %>  value="female"> 
							<label>:Female</label>
					</td>
				</tr>

				<tr>
					<td valign="top"><label>Hobbies: </label></td>
					<td><input name="hobbie" <% for(int i = 0 ; i <= hobbie.length-1 ; i++){ if(hobbie[i].equalsIgnoreCase("Games")){ out.print("checked"); } } %> type="checkbox" value="Games">:Games<br>
						<input name="hobbie" <% for(int i = 0 ; i <= hobbie.length-1 ; i++){ if(hobbie[i].equalsIgnoreCase("Coding")){ out.print("checked"); } } %> type="checkbox"  value="Coding">:Coding<br>
						<input name="hobbie" <% for(int i = 0 ; i <= hobbie.length-1 ; i++){ if(hobbie[i].equalsIgnoreCase("Music")){ out.print("checked"); } } %> type="checkbox" value="Music">:Music<br>
						<input name="hobbie" <% for(int i = 0 ; i <= hobbie.length-1 ; i++){ if(hobbie[i].equalsIgnoreCase("Painting")){ out.print("checked"); } } %> type="checkbox" value="Painting">:Painting<br></td>
				</tr>

				<tr>
					<td valign="top"><label>Languages Know: </label></td>
					<td>
					<input name="language" <% for(int i = 0 ; i <= language.length-1 ; i++){ if(language[i].equalsIgnoreCase("php")){ out.print("checked"); } } %> type="checkbox" value="php">:PHP <br>
				    <input name="language" <% for(int i = 0 ; i <= language.length-1 ; i++){ if(language[i].equalsIgnoreCase("asp.net")){ out.print("checked"); } } %> type="checkbox" value="asp.net">:ASP.NET <br> 
				    <input name="language" <% for(int i = 0 ; i <= language.length-1 ; i++){ if(language[i].equalsIgnoreCase("python")){ out.print("checked"); } } %> type="checkbox" value="python">: Python <br>
					<input name="language" <% for(int i = 0 ; i <= language.length-1 ; i++){ if(language[i].equalsIgnoreCase("java")){ out.print("checked"); } } %> type="checkbox" value="java">:JAVA <br> 
					<input name="language" <% for(int i = 0 ; i <= language.length-1 ; i++){ if(language[i].equalsIgnoreCase("android")){ out.print("checked"); } } %> type="checkbox" value="android">: Android <br></td>
				</tr>  

		

		<tr>
					<td colspan="2">
						<button title="Click To Submit"
							style="background-color: green; border: 1px solid green;"
							name="btnSubmit">Submit</button>
					</td>
				</tr>

			</table>
		</fieldset>
	</form>
</body>
</html>
<% } %>