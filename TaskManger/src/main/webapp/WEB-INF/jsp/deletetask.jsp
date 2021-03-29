<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Task</title>
</head>
<body>
	<h2>Delete Task</h2>
	<table>
		<tr><th>ID</th><th>Name</th><th>Description</th><th>E-mail</th><th>Start Date</th><th>End Date</th><th>Severity</th><th>User ID</th></tr>
		<c:forEach items="${task}" var="task" varStatus="count">
			<tr id="${count.index}">
				<td>${task.id}</td>
				<td style="padding:0 30px 0 30px;">${task.name}</td>
				<td style="padding:0 30px 0 30px;">${task.description}</td>
				<td style="padding:0 30px 0 30px;">${task.email}</td>
				<td style="padding:0 30px 0 30px;">${task.startDate}</td>
				<td style="padding:0 30px 0 30px;">${task.endDate}</td>
				<td style="padding:0 30px 0 30px;">${task.severity}</td>
				<td style="padding:0 30px 0 30px;">${task.user.id}</td>
			</tr>
		</c:forEach>
	</table><br><br>
	<p style="color:green">${message}</p><br>
	<form action="/tasks/deletetask" method="POST">
		<label for="id">Enter task ID to delete:</label>
		<input type="text" placeholder="ID" id="id" name="id"><br><br>
		<input type="submit" value="Delete"><br><br>
	</form><br><br>
	<p style="color:red">${errorMessage}</p><br>
</body>
</html>