<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
table,th,td{
border:lpx solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Users List<hr></h1>
<%
String unm,uid;
try
{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	DBConnector d=new DBConnector();
    con=d.getDcon();
    pst=con.prepareStatement("select *  from users; ");
   	rs=pst.executeQuery();
   	%>
   	<table style="width:50%" border="1" >
   	     <tr>
   	        <th><h2>Username</h2></th>
   	        <th><h2>UserId</h2></th>
         </tr>
        <%
   	while(rs.next())
   	{
   		unm=rs.getString("usernm");
   		uid=rs.getString("userid");
   		%>
   		<tr>
   		  <td><%=unm %></td>
   		  <td><%=uid %></td>
        </tr>
   		<% 
   	}%>
   	</table>
   	<%
   	con.close();
}
catch(Exception e){
	System.out.println(e);
}


%>
<hr>
<a href="CompanyAdmin.jsp">Home</a>
</body>
</html>