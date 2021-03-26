<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>Welcome back ${user}!</h2>
	
	<br>
	Actions: <br><br>
	<ul>
		<li><a href="/displaytasks">Show All Task</a></li>
		<li><a href="/createtask">Create Task</a></li>
		<li><a href="/deletetask">Delete Task</a></li>
		<li><a href="/updatetask">Update Task</a></li>
	</ul>
	
	
</body>
</html>