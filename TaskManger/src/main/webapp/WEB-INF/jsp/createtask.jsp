<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Task</title>
</head>
<body>
	<h2>Create Task</h2>
	<p style="color:green">${message}</p><br>
	<form action="/tasks/createtask" method="POST">
		<label for="name">Task Name:</label>
		<input type="text" placeholder="Task Name" id="name" name="name"><br><br>
		<label for="email">E-mail:</label>
		<input type="text" placeholder="E-mail" id="email" name="email"><br><br>
		<label for="startdate">Start Date:</label>
		<input type="date" id="startdate" name="startdate"><br><br>
		<label for="enddate">End Date:</label>
		<input type="date" id="enddate" name="enddate"><br><br>
		<label for="severity">Severity:</label>
		<select id="severity" name="severity">
    		<option value="low">Low</option>
   			<option value="medium">Medium</option>
    		<option value="high">High</option>
  		</select><br><br>
  		<label for="description">Description:</label><br><br>
		<textarea id="description" placeholder="Description" name="description" rows="4" cols="50"></textarea><br><br>
		<br> <input type="submit" value="Save"><br><br>
		<p style="color:red">${errorMessage}</p><br>
	</form>
</body>
</html>