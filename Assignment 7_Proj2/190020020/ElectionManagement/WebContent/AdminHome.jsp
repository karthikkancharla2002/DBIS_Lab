<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>

<div style="text-align:center">
<h1> Admin Dashboard</h1>
</div>

<div style="
    display: inline-flex;
    justify-content: space-between;
    width: 100%;
    margin: 5% 0%;
">
<div style="
    padding: 10px;
">
<a href="AddVoter.jsp">
   <button>Add Voter</button>
	</a>
</div>

<div style="
    padding: 10px;
">
<a href="AddCandidate.jsp">
   <button>Add Candidate</button>
	</a>
</div>

<div style="
    padding: 10px;
">
<a href="AddPosition.jsp">
   <button>Add Position</button>
	</a>
</div>

<div style="
    padding: 10px;
">

<a href="AddVotingRights.jsp">
   <button>Add Voting Rights</button>
	</a>
</div>




</div>
<div style="text-align:center;">

<h3>
Set Current Stage
</h3>

	<form action="SetStage" method="post">
			<table style="
    margin: auto;
">
				<tbody><tr>
					<td>1</td>
					<td><input type="radio" name="stage" value="1"></td>
				</tr>
				<tr>
					<td>2</td>
					<td><input type="radio" name="stage" value="2"></td>
				</tr>
				<tr>
					<td>3</td>
					<td><input type="radio" name="stage" value="3"></td>
				</tr>
				</tbody></table>
				<input type="submit" value="Set Stage"></form>
</div>
<br>


</body>
</html>