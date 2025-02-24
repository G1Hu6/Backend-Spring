<div class="modal fade" id="profile-model" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="staticBackdropLabel">Edit
						Profile</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<img class="img-fluid" alt="demo.png"
							src="pics/<%=user.getProfile()%>"
							style="border-radius: 50%; max-width: 100px;"> <br>
						<h4><%=user.getName()%></h4>
					</div>
					<div id="user-info">
						<table class="table">

							<tbody>
								<tr>
									<th scope="row">Id :</th>
									<td><%=user.getId()%></td>

								</tr>
								<tr>
									<th scope="row">Email :</th>
									<td><%=user.getEmail()%></td>

								</tr>
								<tr>
									<th scope="row">Summary :</th>
									<td colspan="2"><%=user.getAbout()%></td>

								</tr>
								<tr>
									<th scope="row">Gender :</th>
									<td colspan="2"><%=user.getGender()%></td>

								</tr>
								<tr>
									<th scope="row">Registerrd date :</th>
									<td colspan="2"><%=user.getTime().toString()%></td>

								</tr>
							</tbody>
						</table>
					</div>
					<div id="user-edit" style="display: none;">
						<h4 class="text-center">Please Edit Carefully</h4>
						<form action="EditServlet" method="post"
							enctype="multipart/form-data">
							<table class="table">

								<tbody>
									<tr>
										<th scope="row">Id :</th>
										<td><%=user.getId()%></td>

									</tr>
									<tr>
										<th scope="row">Name :</th>
										<td><input type="text" name="new_name"
											class="form-control" value=<%=user.getName()%>></td>

									</tr>
									<tr>
										<th scope="row">Email :</th>
										<td><input type="text" name="new_email"
											class="form-control" value=<%=user.getEmail()%>></td>

									</tr>
									<tr>
										<th scope="row">Password :</th>
										<td><input type="password" name="new_password"
											class="form-control" value=<%=user.getPassword()%>></td>

									</tr>
									<tr>
										<th scope="row">About :</th>
										<td colspan="2"><textarea rows="2" name="new_about"
												class="form-control"><%=user.getAbout()%></textarea></td>

									</tr>
									<tr>
										<th scope="row">Gender :</th>
										<td colspan="2"><%=user.getGender().toUpperCase()%></td>

									</tr>
									<tr>
										<th scope="row">Profile Picture :</th>
										<td><input type="file" required name="new_profile"
											class="form-control" value=<%=user.getProfile()%>></td>

									</tr>
								</tbody>
							</table>
							<div class="container text-center">
								<button class="btn btn-outline-primary" type="submit">Submit</button>
							</div>

						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button id="edit-btn" type="button" class="btn btn-primary">Edit</button>
				</div>
			</div>
		</div>
	</div>