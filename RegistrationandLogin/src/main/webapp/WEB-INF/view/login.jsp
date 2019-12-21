<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="loginprocess" method="post">
	<center>
		<h1>Login</h1>
		<input type="text" placeholder="username" name="username"><br><br>
		<input type="password" placeholder="password" name="password"><br><br>
		<input type="submit" value="Log in"><br>
		<% Object msg = request.getAttribute("message");
		   if(msg!= null)
		   {
		   out.print(msg);
		   }%>

	</center>
	</form>
</body>
</html>