<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>

</head>
<body
	style="background: url(images/hacker.jpg); background-size: cover; background-attachment: fixed;">
	<div class="column">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card" style="border-radius: 12px;">
					<div class="card-content">
						<span class="card-title center-align">Register Here!!!</span>
						<h5 id="msg" class="center-align"></h5>
						<div class="form center-align">
							<form id="myForm" action="Register" method="post">
								<input type="text" class="validate" name="user_name"
									placeholder="Enter your name" /> <input type="password"
									class="validate" name="user_password"
									placeholder="Enter your password" /> <input type="email"
									class="validate" name="user_email"
									placeholder="Enter your email" />
								<div class="file-field input-field">
									<div class="btn red">
										<span>File</span> <input name="image" type="file">
									</div>
									<div class="file-path-wrapper">
										<input class="file-path validate" type="text">
									</div>
								</div>
								<button class="btn red waves-effect waves-light" type="submit"
									name="action">Submit</button>
							</form>
						</div>
						<div class="loader center-align"
							style="margin-top: 10px; display: none;">
							<div class="preloader-wrapper small active" style="">
								<div class="spinner-layer spinner-blue">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>

								<div class="spinner-layer spinner-red">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>

								<div class="spinner-layer spinner-yellow">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>

								<div class="spinner-layer spinner-green">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>
							</div>
							<h6>Please Wait ...</h6>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				console.log("page is ready");

				$("#myForm").on("submit", function(event) {
					event.preventDefault();

					//var f = $(this).serialize();		// only used for data other than images(byte Stream)
					
					let f = new FormData(this);

					console.log(f);
					$(".loader").show();
					$(".form").hide();

					$.ajax({
						url : "Register",
						data : f,
						type : "POST",
						success : function(data, textStatus, jqXHR) {
							console.log(data);
							console.log("success...");
							$(".loader").hide();
							$(".form").show();

							if (data.trim() === "Done") {
								$("#msg").html("Successfully Registered");
								$("#msg").addClass("green-text");
							} else {
								$("#msg").html("Server Error...");
								$("#msg").addClass("red-text");
							}
						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(data);
							console.log("error...");
							$(".loader").hide();
							$(".form").show();
							$("#msg").html("Server Error...");
							$("#msg").addClass("red-text");
						},
						processData:false,
						contentType:false,
					})
				})
			})
		</script>
	</div>
</body>
</html>