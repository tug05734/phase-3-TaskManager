<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks</title>
</head>
<body>
	<h2>Current Tasks</h2>
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
	</table>
</body>
</html>