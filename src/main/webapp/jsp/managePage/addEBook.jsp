<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加电子书</title>
<!-- <link rel="stylesheet"href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link rel="stylesheet"href="/css/bootstrap/bootstrap.css">
<script src="/js/jquery/jquery-2.1.0.js"></script>
<script src="/js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="/js/getProjectRootPath.js"></script>
<script src="/js/eBook.js"></script>
<style type="text/css">
.h3-center{
	width:20%;
	height:30%;
	margin: 0 auto;
	margin-top:15px;
}
.div-top{
	margin-top:10px;
	margin-left:15%;
	margin-right:0%;
}
</style>
</head>
<body>
	<h3 class="h3-center">添加电子书</h3>
	<div class="div-top">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-2 control-label">书名</label>
				<div class="col-sm-10">
					<input class="form-control" id="bookName" type="text"
						placeholder="请输入书名">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">类型</label>
				<div class="col-sm-10">
					<input class="form-control" id="bookType" type="text"
						placeholder="请选择类型">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">作者</label>
				<div class="col-sm-10">
					<input class="form-control" id="author" type="text"
						placeholder="本书作者">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">价格</label>
				<div class="col-sm-10">
					<input class="form-control" id="price" type="text"
						placeholder="本书价格">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">出版日期</label>
				<div class="col-sm-10">
					<input class="form-control" id="publishDate" type="text"
						placeholder="请选择出版日期">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">描述</label>
				<div class="col-sm-10">
				    <textarea class="form-control" id="describes" rows="3" placeholder="请输入本书的简介"></textarea>
				</div>
			</div>
			<div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button id="addEBook" class="btn btn-default">提交</button>&emsp;
			      <button type="reset" class="btn btn-default">清空	</button>
			    </div>
  			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		/* 添加电子书 */ 
		$("#addEBook").click(function(){
			var url = getLocalhostPaht()+"/eBook/addEBook.do"; 
			var data = {"bookName":$("#bookName").val(),"bookType":$("#bookType").val(),"author":$("#author").val(),"price":$("#price").val(),"publishDate":$("#publishDate").val(),"describes":$("#describes").val()};
			addEBook(url,data);
		});
	});
</script>
</html>