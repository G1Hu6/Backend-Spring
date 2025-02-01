<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
	<h1>This is Home page</h1>
	<%
		String name = (String)request.getAttribute("name");
		Integer id = (Integer)request.getAttribute("id");
		List<String> cart = (List<String>)request.getAttribute("cart");
	%>
	<h3>Name = <%=name %></h3>
	<h3>Id = <%=id %></h3>
	<%
		for(String s:cart){
	%>
		<h2><%=s %></h2>		
	<%
		}
	%>
</body>
</html>