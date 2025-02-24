<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.tech.blog.entities.Message"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.mybox {
	clip-path: polygon(0 0, 100% 0, 100% 88%, 0 51%);
}
</style>
</head>
<body>

	<!-- navbar -->
	<%@include file="navbar.jsp"%>

	<main style="height: 100vh;"
		class="mybox align-items-center bg-primary pt-2">
		<div class="comtainer-fluid">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card mx-2">
						<div class="card-header">
							<h3>Login Here</h3>
						</div>
						<%
						Message m = (Message) session.getAttribute("message");
						if (m != null) {
						%>
						<div class="alert <%=m.getCssClass()%> alert-dismissible fade show"
							role="alert">
							<strong><%=m.getContent()%></strong>
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>

						<%
							session.removeAttribute("message");
						}
						%>
						<div class="card-body">
							<form action="LoginServlet" method="post">

								<div class="form-group">
									<label for="staticEmail2">Email</label> <input name="email"
										required type="text" class="form-control" id="staticEmail2"
										placeHolder="email@example.com">
								</div>
								<div class="form-group">
									<label for="inputPassword2">Password</label><input
										type="password" name="password" required class="form-control"
										id="inputPassword2" placeholder="Password">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary mb-2 mt-3">Confirm
										identity</button>
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- javascript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
</body>
</html>