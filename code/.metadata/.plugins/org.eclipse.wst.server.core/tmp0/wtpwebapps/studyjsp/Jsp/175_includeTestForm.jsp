<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
	<form action="176_includeTest.jsp" method="post">
	<label for="name">이름</label>
	<input id="name" name="name" type="text">
	<label for="pagename">포함할 페이지</label>
	<input id="pagename" name="pageName" type="text"
	value="177_includedTest.jsp" required>
	
	<input type="submit" value="전송">
	
	</form>

</body>
</html>