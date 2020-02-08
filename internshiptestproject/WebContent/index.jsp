<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="header"><h1>Home Page</h1></div>
<img alt="FileSharing Website" src="FileSharing.jpg" width="1100" height="600">
<div class="row">
<form name="frm" method="post" action="Check">
<table>
<tr>
<td>UserID
<td><input type="text" name="txt">
</tr>

<tr>
<td>Password
<td><input type="password" name="psw">
<% 
Calendar cal=Calendar.getInstance();
String dt=String.valueOf(cal.getTime());
%>
<input type="hidden" name="logdt" value="<%=dt%>">
</tr>

<tr>
<td><input type="submit" value="Submit">
<td>
</tr>

</table>
</form>
<br>
<a href="ForgetPass.html">Forget Password</a>|
<a href="Register.html">New Regestration</a>|
</div>
</body>
</html>