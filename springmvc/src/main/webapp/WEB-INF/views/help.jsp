<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.time.LocalDateTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help page</title>
</head>
<body>
	<h1>These is Help Page</h1>
	<%-- <%
		String name = (String) request.getAttribute("name");
		Integer rollNum = (Integer) request.getAttribute("rollnumber");
		LocalDateTime date = (LocalDateTime) request.getAttribute("date");
	%>
	<h2><%=name %></h3>
	<h2><%=rollNum %></h3>
	<h2><%=date %></h3> --%>
	
	<h2>Name :${name}</h2>
	<h2>
	Roll No :${rollnumber}
	</h2>
	<h2>Date:${date}</h2>
	<h1>
	${marks}
	</h1>
	<hr>
	<c:forEach items="${marks}" var="item">
		<h1>${item}</h1>
	</c:forEach>
</body>
</html>