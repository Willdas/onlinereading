//添加电子书
function addEBook(url,data){
	$.ajax({
		type : "get",
		url : url,
		data : data,
		success : function(data){
			console.log(data);
		}
	});
	
}