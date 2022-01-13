<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voter Login</title>
</head>
<body>
<h1>Enter Voter ID and Password</h1>
<form action="VoterLogin" method="post">
			<table style="with: 50%">
				<tr>
					<td>Voter Id</td>
					<td><input type="text" name="voter_id" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				

			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>
