<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>Welcome back ${userName}!</h2>
	
	<br>
	Actions: <br><br>
	<ul>
		<li><a href="/tasks/displaytasks">Show All Task</a></li>
		<li><a href="/tasks/createtask">Create Task</a></li>
		<li><a href="/tasks/deletetask">Delete Task</a></li>
		<li><a href="/tasks/updatetask">Update Task</a></li>
	</ul>
	<br><p hidden>${userEmail}${userPassword} </p>
</body>
</html>