<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<!-- navbar -->
	<%@include file="navbar.jsp"%>

	<main style="height: 100vh;" class="mybox bg-primary pt-2">
		<div class="comtainer">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card mx-2">
						<div class="card-header text-center">
							<h3>Register Here</h3>
						</div>
						<div class="card-body">
							<form action="RegisterServlet" method="post" id="myform">
								<div class="form-group">
									<div class="col-auto">
										<label>Name</label> <input type="text" required name="name"
											class="form-control" placeholder="Enter Full Name">
									</div>
									<div class="col-auto">
										<label for="staticEmail2">Email</label> <input required name="email"
											type="text" class="form-control" id="staticEmail2"
											placeholder="email@example.com">
									</div>
									<div class="col-auto">
										<label for="inputPassword2">Password</label> <input required
											name="password" type="password" class="form-control"
											id="inputPassword2" placeholder="Password"> <input required
											type="radio" name="gender" value="Male">Male <input required
											type="radio" name="gender" value="Female">Female
									</div>
									<div class="mb-3">
										<label for="exampleFormControlTextarea1" class="form-label">About
											yourself</label>
										<textarea class="form-control" name="about"
											id="exampleFormControlTextarea1" rows="2"></textarea>
										<input type="checkbox" name="check">Agree Terms and Conditions
									</div>
									<div id="loader" class="container text-center" style="display:none;">
										<div class="spinner-border text-success" role="status">
										<span class="visually-hidden">Loading...</span>
									</div>
									<h5> Please Wait</h5>
									</div>
									
									<div class="col-auto">
										<button id="mybutton" type="submit" class="btn btn-primary mb-2 mt-1">
											Submit</button>
									</div>

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

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			console.log("loading...");
			
			$('#myform').on('submit',function(event){
				event.preventDefault();
				
				let form = new FormData(this);
				
				$('#loader').show();
				$('#mybutton').hide();
				
				$.ajax({
					url:"RegisterServlet",
					type:"post",
					data:form,
					success:function(data,textStatus,jqXHR){
						$('#loader').hide();
						$('#mybutton').show();
						if(data.trim() =="done"){
							swal("Successfully registered...Click here to go on Login Page.")
							.then((value) => {
							   window.location = "login.jsp";
							});
						}else{
							swal(data);
						}
					},
					error:function(jqXHR,textStatus,errorThrown){
						$('#loader').hide();
						$('#mybutton').show();
						swal("Something went wrong...Please try again");
					},
					processData:false,
					contentType:false,
				})
			})
		})
	</script>
</body>
</html>