<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="header">
<h2 style="color:blue">Admin page</h2>
</div>
<%
String uid,logtm;
uid=session.getAttribute("userid").toString();
logtm=session.getAttribute("logindtm").toString();
%>

<center><h3>Welcome: <%=uid %></h3></center>
<hr>
<a href="Userlist.jsp">List Of Users</a>|
<a href="Login.html">Login History</a>|
<a href="actideacti.jsp">Activation/Deactivation</a>|
<a href="Logout.jsp">Logout</a>|

</body>
</html>