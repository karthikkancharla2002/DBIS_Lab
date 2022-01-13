<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Election Management System</title>
</head>
<body>

<div style="text-align:center;">
<h1>
Election Management System
</h1>
</div>

<div >
<div style="
    margin: 10% 20%;
    text-align: center;
    display: inline-flex;
    justify-content: space-between;
    width: 60%;
">
<div style="
    padding: 10px;
">
<a href="AdminLogin.jsp" style="
">
   <button>Admin Login</button>
	</a>
</div>
<div style="
    padding: 10px;
">
<a href="VoterLogin.jsp">
   <button>Vote</button>
	</a>

</div>
<div style="
    padding: 10px;
">

	
<form action="Results" method="post">
<input type="submit" value="View Results"></form>
</div>

<div style="
    padding: 10px;
">
<form action="ViewData" method="post">
<input type="submit" value="View Data"></form>

</div>

</div>

</body>
</body>
</html>