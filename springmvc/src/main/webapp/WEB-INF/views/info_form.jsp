<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">

<title>Info Page</title>
</head>
<body>
	<div class="container mt-3">
		<form action="output" method="post">
			<h1>Sign In Page</h1>
			<h1>${Header}</h1>
			<h1>${Data}</h1>
			<hr>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control" name="email"
					aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control" name="pass">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Roll No</label> <input
					type="text" class="form-control" name="rollno"
					aria-describedby="emailHelp">

			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div>
			<div class="container text-center">
				<button type="submit"  class="btn btn-primary">Sign In</button>
			</div>
		</form>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/js/jscript.js"/>" type="text/javascript"></script>
</body>
</html>