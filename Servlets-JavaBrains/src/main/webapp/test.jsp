<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.Date"%>
<!DOCTYPE html PUBLIC
"-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test page</title>
</head>
<body>
	<%!
	int add(int a, int b) {
		return a + b;
	}
	%>
	
	<%
		int a = 3;
		int b = 5;
	%>
	
	<h3>The result is of <%=a%> + <%=b%> is <%= add(a, b) %></h3>
	
	<%	for (int i = 0; i < 4; i++) { %>
		<h4>The value of i = <%=i %></h4 >
	<%} %>
	
	The time is <%=new Date() %>
	
	<h2>Your name is <%=request.getParameter("name") %></h2>
	<% session.setAttribute("name", request.getParameter("name")); %>
	<% application.setAttribute("name", request.getParameter("name")); %>
			
</body>
</html>