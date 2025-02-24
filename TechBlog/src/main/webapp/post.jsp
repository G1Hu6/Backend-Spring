<%@page import="com.tech.blog.entities.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>

<div class="row">
	<%
	int catId = Integer.parseInt(request.getParameter("cid"));

	PostDao pd = new PostDao(ConnectionProvider.createConnection());
	ArrayList<Post> pList = null;

	if (catId == 0) {
		pList = pd.getAllPosts();
	} else {
		pList = pd.getPostsByCategory(catId);
	}

	if (pList.isEmpty()) {
		out.println("<h3 class='display-3 text-center'>No Post in this Category</h3>");
	}

	for (Post post : pList) {
	%>
	<div class="col-md-6">
		<div class="card mb-2">
			<div class="card-header">
				<b><%=post.getpTitle()%></b>

			</div>
			<img src="post_pics/<%=post.getpImage()%>" class="card-img-top"
				alt="...">
			<div class="card-body">
				<p><%=post.getpContent()%></p>
			</div>
			<div class="card-footer text-center">
				<a class="btn btn-outline-primary" href="single_post.jsp?post_id=<%=post.getpId()%>">Read More</a>
			
				
					<a type="button"class="btn btn-outline-primary" href="#!"><i class="fa fa-thumbs-o-up">10</i></a>
				<a class="btn btn-outline-primary" href="#!"><i class="fa fa-commenting-o">20</i></a>
				
			
			</div>
		</div>
	</div>
	<%
	}
	%>
</div>
