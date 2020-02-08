<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String seq,ans,status,id,pass,status1;

id=request.getParameter("uid");
seq=request.getParameter("Question");
ans=request.getParameter("txt");
ForgetPassBean m1=new ForgetPassBean();
m1.setId(id);
m1.setSeq(seq);
m1.setAns(ans);


status=m1.getStatus();
if(status=="success")
{
	String ps=m1.getPass();
	ps="Password";
	Changepass n=new Changepass();
	n.setId(id);
	n.setPass(ps);
	status1=n.getStatus();
	if(status=="success")
	{
		out.println("Your default password is:"+ps);
		
	}
	else
	{
		out.println("Failed");
		
	}
	
}
else
{
	out.println("Authentication Failed");
}

%>


<br>
<a href="index.jsp">HOME</a>

</body>
</html> 