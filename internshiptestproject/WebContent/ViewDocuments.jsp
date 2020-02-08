<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.DBConnector" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><b>Here are the list of Documents which are uploaded by the All Members</b></h3>
<br>
<hr>
<table border='2'>
<tr>
<th>File Name
<th>Uploaded by (User Id)
<th>Uploaded by (Name)
<th>Upload Date
<th>Upload Time
<th>File Type
<th>Download
</tr>
<%
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("index.jsp");
}
else
{
String uid;
uid=session.getAttribute("userid").toString();

ResultSet rs;
String fnm;
try
{
	CheckPermissions ckpm = new CheckPermissions();
	ckpm.setUid(uid);
	rs=ckpm.ckPermission();

	while(rs.next())
	{
		
		fnm=rs.getString("fnm");
%>
<tr>
<td><%=rs.getString("fnm") %>
<td><%=rs.getString("userid") %>
<td><%=rs.getString("usernm") %>
<td><%=rs.getString("udate") %>
<td><%=rs.getString("utime") %>
<td><%=rs.getString("ftype") %>
<td><a href="Download?fnm=<%=fnm%>">Download</a>
</tr>

<%
	}

}
catch(Exception e)
{
	System.out.println(e);
}
}
%>
</table>
</body>
</html>