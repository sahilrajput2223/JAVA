<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
 
 <style type="text/css">
 	form{
 	padding: 100px;
 	}
 	fieldset{
 	margin-top: 2%;
 	margin-left: 35%;
 	height: 400px;
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
<form action="Display_Data" method="POST">
	<fieldset>
		<legend>Registration Page</legend>

		<table>
			<tr>
				<td><label>First Name: </label></td>
				<td><input type="text" name="fname"
					placeholder="Enter First Name"></td>
			</tr>

			<tr>
				<td><label>Last Name: </label></td>
				<td><input type="text" name="lname"
					placeholder="Enter Last Name"></td>
			</tr>

			<tr>
				<td><label>Age: </label></td>
				<td><input type="text" name="age" placeholder="Enter Age"></td>
			</tr>

			<tr>
			<td><label>Phone No: </label></td>
			<td><input type="text" name="phone" placeholder="Enter Phone No"></td>
			</tr>
		
			<tr>
			<td><label>Email: </label></td>
			<td><input type="email" name="email" placeholder="Enter Email "></td>
			</tr>
	
			<tr>
			<td><label>Birth Date: </label></td>
			<td><input type="date" name="birthdate" placeholder="Enter Birth Date" ></td>
			</tr> 
	
			<tr>
			<td><label>Gender: </label></td>
			<td><input type="radio" name="gender" value="male">
			<label>:Male</label>
			<input type="radio" name="gender" value="female">
			<label>:Female</label></td>
			</tr>
			
			<tr>
			<td valign="top"><label>Hobbies: </label></td>
			<td><input name="hobbie" type="checkbox" value="Games" >:Games<br>
				<input name="hobbie" type="checkbox" value="Coding" >:Coding<br>
				<input name="hobbie" type="checkbox" value="Music" >:Music<br>
				<input name="hobbie" type="checkbox" value="Painting" >:Painting<br></td>
			</tr>
			
			<tr>
			<td valign="top"> <label>Languages Know: </label></td>
			<td><input name="language" type="checkbox" value="php" >: PHP <br>
				<input name="language" type="checkbox" value="asp.net" >: ASP.NET <br>
				<input name="language" type="checkbox" value="python" >: Python <br>
				<input name="language" type="checkbox" value="java" >: JAVA <br>
				<input name="language" type="checkbox" value="android" >: Android <br></td>
			</tr>
			
			<tr>
			 <td colspan="2" > <button title="Click To Submit" style="background-color: green; border: 1px solid green;" name="btnSubmit" >Submit</button> </td>
			</tr>
			 	
		</table>
	</fieldset>
</form>
</body>
</html>