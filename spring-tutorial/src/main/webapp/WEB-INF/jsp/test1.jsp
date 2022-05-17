<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Test1<br>
	<form action="/test2" method="get">
		<button type="submit">get 요청하기</button>
	</form>
	
	<form action="/test2" method="post">
		<button type="submit">post 요청하기</button>
	</form>
</body>
</html>