<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error!!!</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container p-3 text-center">
		<img class="img-fluid" alt="Error" src="<c:url value="/resources/images/error.png"/>">
		<h3 class="display-3">Something went wrong!!!</h3>
		<h6>${message}</h6>
		<a class="btn btn-outline-primary" href="home">Home Page</a>
		<a class="btn btn-outline-primary" href="index.html">Contact Page</a>
	</div>
</body>
</html>