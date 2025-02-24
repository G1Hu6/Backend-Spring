<%@page import="com.tech.blog.dao.LikeDao"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.tech.blog.dao.UserDao"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.tech.blog.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@ page errorPage="error_page.jsp"%>
<%@ page import="com.tech.blog.entities.User"%>
<%@ page import="com.tech.blog.entities.Message"%>

<%
User user = (User) session.getAttribute("currentUser");

if (user == null) {
	response.sendRedirect("login.jsp");
}
%>

<%
int postId = Integer.parseInt(request.getParameter("post_id"));
PostDao pd2 = new PostDao(ConnectionProvider.createConnection());
UserDao ud = new UserDao(ConnectionProvider.createConnection());
LikeDao ld = new LikeDao(ConnectionProvider.createConnection());
Post post = pd2.getPostsByPostId(postId);
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%=post.getpTitle()%></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />

<!-- javascript -->
<script src="javascript/myjs.js"></script>

</head>
<body>
	
	<%!
		String likeIcon = "fa fa-thumbs-o-up";
	%>
	<!-- navbar -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"><span
				class="fa fa-building"></span>TechBlog</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="profile.jsp"><span
							class="fa fa-handshake-o"></span>LearnCode</a></li>
					<li class="nav-item"><a class="nav-link" href="#"><span
							class="fa fa-bell-o">Contact</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <span
							class="fa fa-check-square-o"></span>Categories
					</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Java</a></li>
							<li><a class="dropdown-item" href="#">Sprinng Boot</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Data Structure </a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#" data-bs-toggle="modal"
						data-bs-target="#blog-post-model"><span
							class="spinner-grow text-warning"
							style="width: 15px; height: 15px;" role="status"></span> Post
							Blog</a></li>
				</ul>
				<form class="d-flex justify-content-between">

					<div class="d-inline-flex p-0">
						<img alt="demo.png" data-bs-toggle="modal"
							data-bs-target="#profile-model" src="pics/<%=user.getProfile()%>"
							style="border-radius: 50%; max-width: 40px;"> <a
							class="nav-link active text-light" data-bs-toggle="modal"
							data-bs-target="#profile-model" href="#!" aria-current="page"><%=user.getName()%></a>
					</div>
					<a href="LogoutServlet" class="btn btn-danger" type="button">Logout</a>
				</form>
			</div>
		</div>
	</nav>


	<!-- main body -->
	<div class="container">
		<div class="row my-3">
			<div class="col-md-8">
				<div class="card">
					<img src="post_pics/<%=post.getpImage()%>" class="card-img-top"
						alt="...">
					
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h3><%=post.getpTitle()%></h3>
						
					</div>
					<div class="card-body">
						<form class="d-flex justify-content-between">
							<p>by <a href="#">@<%= ud.getUserByUserId(post.getUserId()).getName()%></a></p>
							<p><%=DateFormat.getDateInstance().format(post.getpDate() )%></p>
						</form>
						<p><%=post.getpContent()%></p>
					</div>
					
					<% 
						if(ld.isLikedByUser(post.getpId(), user.getId())){
								likeIcon = "fa fa-thumbs-down";
						}
					%>
					
					<div class="card-footer text-center">
						<a type="button" id='like-counter' class="btn btn-outline-primary btn-lg mx-2" onclick="doLike(<%= post.getpId() %>,<%= user.getId() %>)"
							href="#!"><i class="<%=likeIcon%>"><%=ld.countLikesonPost(post.getpId())%></i></a> 
						<a
							class="btn btn-outline-primary btn-lg mx-2" href="#!"><i
							class="fa fa-commenting-o">20</i>
						</a>


					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-body">
						<h4>Source Code :</h4>
						<pre><%=post.getpCode()%></pre>
					</div>
				</div>
			</div>
		</div>
	</div>




	<!-- profile Edit Modal -->
	<%@include file="profile_model.jsp"%>

	<!-- blog post model -->
	<%@include file="blog_model.jsp"%>

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
		$(document).ready(function() {

			var isEdit = true;
			$('#edit-btn').click(function() {
				if (!isEdit) {
					$('#user-info').show();
					$('#user-edit').hide();
					$('#edit-btn').text("Edit");
				} else {
					$('#user-info').hide();
					$('#user-edit').show();
					$('#edit-btn').text("Back");
				}
				isEdit = !isEdit;
			})

		})
	</script>

	<!-- addPost js -->
	<script type="text/javascript">
		$(document).ready()
		{
			console.log("loading..");
			$("#post-form").on("submit",function(event){
				
				event.preventDefault();
				
				let form = new FormData(this);
				
				$.ajax({
					url:"AddPostServlet",
					type:"post",
					data: form,
					success: function(data, textStatus, jqXHR){
						console.log(data);
						if(data.trim() == 'done'){
							swal("Good job!", "Post is updated Successfully!", "success").then((value) => {
								$('#blog-post-model').modal('hide');
							});
						}else{
							swal("Error!", "Something went wrong!", "error");
						}
					},
					error: function(jqXHR,textStatus,errorThrown ){
						swal("Error!", "Something went wrong!", "error");
					},
					processData:false,
					contentType:false,
				})
			});
		}
	</script>
</body>
</html>