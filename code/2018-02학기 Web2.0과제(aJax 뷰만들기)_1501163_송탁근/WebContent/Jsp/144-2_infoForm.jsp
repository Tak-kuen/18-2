<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoForm</title>
</head>
<body>
	<h2>나이를 입력하세요</h2>
	<form method="get" action = "146-2_infoTest.jsp">
		<label for="age">나이: </label>
		<input id="age" name="age" type="number" autofocus required><br/>
		<input type="submit" value="전송">
	</form>
</body>
</html>