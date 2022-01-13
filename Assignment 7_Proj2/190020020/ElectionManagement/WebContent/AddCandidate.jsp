<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Candidate</title>
</head>
<body>
<h1>Candidate Details </h1>
<form action="AddCandidate" method="post">
			<table style="with: 50%">
				<tr>
					<td>Candidate Id</td>
					<td><input type="text" name="candidate_id" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" /></td>
				</tr>
					<tr>
					<td>Date of Birth</td>
					<td><input type="text" name="dob" /></td>
				</tr>
					</tr>
					<tr>
					<td>City</td>
					<td><input type="text" name="city" /></td>
				</tr>
					</tr>
					<tr>
					<td>State</td>
					<td><input type="text" name="state" /></td>
				</tr>
					</tr>
					<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
					</tr>
					<tr>
					<td>Position ID</td>
					<td><input type="text" name="position_id" /></td>
				</tr>
				
				</tr>
					</tr>
					<tr>
					<td>Manifesto Link</td>
					<td><input type="text" name="manifesto_link" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>
