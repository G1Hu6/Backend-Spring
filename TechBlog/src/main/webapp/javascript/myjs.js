function doLike(pId, uId){
	
	//creating object
	const data = {
		p_id:pId,
		u_id:uId,
		operation :"like",
	};
	
	$.ajax({
		url:"LikeServlet",
		data:data,
		success:function(data, textStatus, jqXHR){
			console.log(data);
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log(data);
		}
	});
}