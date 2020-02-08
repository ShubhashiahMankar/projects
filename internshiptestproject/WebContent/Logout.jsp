<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();
%>
<h3>Your are successfully logged out.</h3>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>