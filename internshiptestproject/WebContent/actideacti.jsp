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
<h1>Users List</h1><hr> 
<%
String unm,uid,sta;
try
{
	Connection con;
	PreparedStatement pst,pst1;
	ResultSet rs,rs1;
	DBConnector d=new DBConnector();
    con=d.getDcon();
    pst=con.prepareStatement("select adminpermit.status,adminpermit.userid,users.usernm  from users inner join adminpermit on users.userid=adminpermit.userid; ");
   	rs=pst.executeQuery();
   	
   	%>
   	<table style="width:50%" >
   	     <tr>
   	        <th><h2>Username</h2></th>
   	        <th><h2>UserId</h2></th>
   	         <th><h2>Status</h2></th>
         
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
 <%  
   		if(rs.getString("status").equals("Activate"))
		{
%>
         
	<td><a href="Deactivate1.jsp?usid=<%=uid%>">Deactivate</a>
<% 
		}
		else
		{
%>
	<td><a href="Activate.jsp?usid=<%=uid%>">Activate</a>
<% 
		}
   	}
%>
	</tr>
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