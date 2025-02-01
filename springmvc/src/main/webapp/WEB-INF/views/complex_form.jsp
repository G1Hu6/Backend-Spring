<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Hello, world!</title>
</head>
<body>
	<div class="container mt-5">
		<div class="alert alert-danger" role="alert">
		<form:errors path="student.*"/>
		</div>
		<form action="handle_complex" method="post">
			<div class="form-group">
				<label>Name</label> <input type="text" class="form-control"
					name="name" placeholder="Enter Full Name">
			</div>
			<div class="form-group">
				<label>Id</label> <input type="text" class="form-control" name="id"
					placeholder="Student Id">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">Email address</label> <input
					type="email" class="form-control" name="email"
					placeholder="name@example.com">
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Select Division</label> <select
					class="form-control" name="division">
					<option>A</option>
					<option>B</option>
					<option>C</option>
					<option>D</option>
					<option>E</option>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect2">Select Coding
					Languages</label> <select multiple class="form-control" name="languages">
					<option>Java</option>
					<option>C</option>
					<option>Cpp</option>
					<option>Python</option>
					<option>Ruby</option>
				</select>
			</div>
			<label for="exampleFormControlSelect2">Select Gender</label>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender"
					id="exampleRadios1" value="Male"> <label
					class="form-check-label" for="exampleRadios1"> Male </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender"
					id="exampleRadios2" value="Female"> <label
					class="form-check-label" for="exampleRadios2"> Female </label>
			</div>
			<div class="card">
				<div class="card-header">
					<label>Address</label>
				</div>
				<div class="card-body">
					<div class="form-group">
						<label for="inputAddress">Street</label> <input type="text"
							name="address.street" class="form-control" id="inputAddress"
							placeholder="1234 Main St">
					</div>
					<div class="form-group">
						<label for="inputAddress2">City</label> <input type="text"
							class="form-control" id="inputAddress2" name="address.city"
							placeholder="your city">
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>
