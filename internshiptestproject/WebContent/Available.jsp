 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mybeans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String uid1;
uid1=request.getParameter("uid2");
CheckAvailable js=new CheckAvailable();
js.setUserid(uid1);
if(js.getStatus().equals("failed"))
{
%>
<span style="color:red">Sorry userid <%=uid1 %> NOT available</span>
<%
}
else
{
%>
<span style="color:green">Congrats userid <%=uid1 %> is available</span>
<%
}
%>


</body>
</html>