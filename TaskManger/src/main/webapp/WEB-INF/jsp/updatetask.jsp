<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Task</title>
</head>
<body>
	<h2>Update Task</h2>
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
	<form action="/tasks/updatetask" method="POST">
		<label for="id">*Task ID:</label>
		<input type="text" placeholder="Task ID" id="id" name="id"><br><br>
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
	<br>*Task ID must be the ID of the task you wish to update
</body>
</html>