<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form role="form" method="post">	
		<div>
			<label for="exampleInputEmail1" >Title</label>
			<input type="text"
				name='title' placeholder="Enter Title" >
		</div>
		<div>
			<label for="exampleInputPassword1">Content</label>
			<textarea rows="3" name="content" placeholder="Enter........">
			</textarea>
		</div>	
		<div>
			<label for="exampleInputEmail1">Writer</label>
			<input type="text"
				name="writer" placeholder="Enter Writer">
		</div>	
		<div>
			<button type="submit">Submit</button>
		</div>
	</form>
</body>
</html>