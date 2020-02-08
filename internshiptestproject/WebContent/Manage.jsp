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
String m,eid,seq,ans,mno;
int age;
HttpSession ses=request.getSession(true);
m=ses.getAttribute("userid").toString();
ProBean cj=new ProBean();
cj.setId(m);
age=cj.getAge();
mno=cj.getMno();
eid=cj.getEid();
seq=cj.getSeq();
ans=cj.getAns();
%>
<h1>Edit Profile</h1><hr>

<form name="frm" method="post" action="Updateprofile">
<table>
<tr>
<td>Age
<td><input type="number" name="txt" value="<%=age%>">
</td>
</tr>
<tr>
<td>Mobile Number
<td><input type="number" name="mno" value="<%=mno%>">
</td>
</tr>
<tr>
<td>EmailId
<td><input type="Text" name="eid" value="<%=eid%>">
</td>
</tr>
<tr>
<td>Security Question 
<td><select name="ques" value="<%=seq%>">
<option value="What is your birth place?">What is your birth place?
<option value="Who is your favorite filmstar?">Who is your favorite filmstar?
<option value="Which color do you like the most?">Which color do you like the most?
<option value="Which is your favorite tourist destination?">Which is your favorite tourist destination?
</select>
</td>
</tr>
<tr>
<td>Answer
<td><input type="text" name="ans" value="<%=ans%>">
</tr>

<tr>
<td><input type="submit" value="Save">
<td>
</tr>



</table>




</form>
</body>
</html>