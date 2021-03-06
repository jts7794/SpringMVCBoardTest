<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>

<!-- 이 부분이 있어야 레디 함수가 작동 ($(document).ready(function(){) -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>

<script type="text/javascript">
$(document).ready(function(){
	
	var formObj = $("form[role='form']");

	console.log(formObj);
	
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/board/modify");
		formObj.attr("method","get");
		formObj.submit();
		});

	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/board/remove");
		formObj.submit();
		});

	$(".btn-primary").on("click", function(){
		self.location = "/board/listAll";
		});
	
});


</script>


<form role="form" method="post">

	<input type='hidden' name='bno' value="${boardVO.bno}">

</form>

<div>
	<label for="exampleInputEmail">Title</label>
	<input type="text" name='title' value="${boardVO.title}"
	readonly="readonly">
</div>
<div>
	<label for="exampleInputPassword1">Content</label>
	<textarea name="content" rows="3"
	readonly="readonly">${boardVO.content}</textarea>
</div>
<div>
	<label for="exampleInputEmail1">Writer</label>
	<input type="text" name="writer" value="${boardVO.writer}"
	readonly="readonly">
</div>

<div>
<button type="submit" class="btn btn-warning">Modify</button>
<button type="submit" class="btn btn-danger">REMOVE</button>
<button type="submit" class="btn btn-primary">LIST ALL</button>

</div>
</body>
</html>