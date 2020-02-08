<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String uid,unm,date;
int n;
uid=request.getParameter("uid");
LoginBean j=new LoginBean();
j.setUid(uid);
unm=j.getUnm();
n=j.getM();
date=j.getDate();
%>
<table>
<tr>
<td>Username:- <%=unm %></td></tr>
<tr><td>Count:- <%=n%></td></tr>
<tr><td>Date:- <%=date%></td></tr>
</table>
<hr>
<a href="CompanyAdmin.jsp">Home</a>
</body>
</html>