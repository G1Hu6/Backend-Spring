
<%@page import="com.tech.blog.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<div class="modal fade" id="blog-post-model" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="staticBackdropLabel">Post Blog</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="AddPostServlet" method="post" id="post-form">
					<div class="mb-3 mx-2 row">
						<select class="form-control" name="cid">
							<option selected disabled class="form-control">---
								Select Category ---</option>

							<%
							PostDao pd = new PostDao(ConnectionProvider.createConnection());
							ArrayList<Category> list = pd.getAllCategories();

							for (Category category : list) {
								//System.out.println(category.getcName()+ " : " +category.getcId());
							%>
							<option value="<%=category.getcId()%>" class="form-control"><%=category.getcName()%></option>

							<%
							}
							%>
						</select>
					</div>
					<div class="mb-3 mx-2 row">
						<input type="text" placeholder="Enter your Post Title"
							name="title" class="form-control">
					</div>
					<div class="mb-3 mx-2 row">
						Enter your Content
						<textarea rows="3" placeholder="Enter your Content" name="content"
							class="form-control">
							</textarea>
					</div>
					<div class="mb-3 mx-2 row">
						Enter your Program (If any...)
						<textarea placeholder="Enter your Program (If any...)" rows="3"
							name="code" class="form-control">
							</textarea>
					</div>
					<div class="mb-3 mx-2 row">
						Enter your Image <input type="file" placeholder="Enter your Image"
							name="image" class="form-control">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Post</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

