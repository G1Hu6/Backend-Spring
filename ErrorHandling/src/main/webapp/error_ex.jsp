<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Something went wrong!!!</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container p-3 text-center">
		<img class="img-fluid" alt="Error" src="images/error.png">
		<h1 class="display-3">Something went wrong!!!</h1>
		<p><%= exception %></p>
		<a class="btn btn-outline-primary" href="index.html">Home Page</a>
		<a class="btn btn-outline-primary" href="index.html">Contact Page</a>
	</div>
</body>
</html>