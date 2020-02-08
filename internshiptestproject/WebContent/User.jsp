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
<h2 style="color:blue">User Home page</h2>
</div>
<%
String uid,logtm;
uid=session.getAttribute("userid").toString();
logtm=session.getAttribute("logindtm").toString();
%>

<center><h3>Welcome : <%=uid %></h3></center>
<hr>


<a href="Manage.jsp">Manage Profile</a>|
<a href="Change.html">Change Password</a>|
<a href="Upload.html">Upload Documents</a>|
<a href="ViewDocuments.jsp">Dowload</a>|
<a href="Permissions.jsp">Permission</a>|
<a href="Logout.jsp">Log-out</a>|

</body>
</html>