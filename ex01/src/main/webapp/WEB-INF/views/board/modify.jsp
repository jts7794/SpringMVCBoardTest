<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

</head>

<script type="text/javascript">
$(document).ready(function(){
	
	var formObj = $("form[role='form']");

	console.log(formObj);
	
	
	$(".btn-warning").on("click", function(){
		self.location = "/board/listAll";
		});

	$(".btn-primary").on("click", function(){
		formObj.submit();
		});
	
});


</script>

<body>

<form role="form" method="post">


	<div>
		<label for="exampleInputEmail1">BNO</label>
		<input type="text" name='bno' value="${boardVO.bno}"
		readonly="readonly">
	</div>
	
	<div>
		<label for="exampleInputEmail1">TITLE</label>
		<input type="text" name='title' value="${boardVO.title}">
	</div>
	
	<div>
		<label for="exampleInputPassword1">Content</label>
		<textarea name="content" rows="3">${boardVO.content}</textarea>
	</div>
	
	<div>
		<label for="exampleInputEmail1">Writer</label>
		<input type="text" name="writer" value="${boardVO.writer}"
		readonly="readonly">
	</div>	
	
	<div>
	<button type="submit" class="btn btn-primary">SAVE</button>
	<button type="submit" class="btn btn-warning">CANCEL</button>
	</div>
	
	
</form>
</body>
</html>