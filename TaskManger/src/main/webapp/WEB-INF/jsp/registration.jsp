<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h2>Register</h2>
	<form action="/registration" method="POST">
		<label for="name">Name:</label>
		<input type="text" placeholder="Name" id="name" name="name"><br><br>
		<label for="email">E-mail:</label>
		<input type="text" placeholder="E-mail" id="email" name="email"><br><br>
		<label for="password">Password:</label>
		<input type="password" placeholder="Password" id="password" name="password"><br><br>
		<label for="password1">Confirm Password:</label>
		<input type="password" placeholder="Confirm Password" id="password1" name="password1"><br><br>  
		<br> <input type="submit" value="Register"><br><br>
	</form>
	<p style="color:red">${errorMessage}</p><br>
</body>
</html>