<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Position</title>
</head>
<body>
<h1>Position Details </h1>
<form action="AddPosition" method="post">
			<table style="with: 50%">
				<tr>
					<td>Position Id</td>
					<td><input type="text" name="position_id" /></td>
				</tr>
				<tr>
					<td>Position Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				
			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>
