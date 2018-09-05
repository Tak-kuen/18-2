<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>researchTestForm1</title>
</head>
<body>
<h2>request 예제 - 요청 메소드</h2><br/>
<h2>설문조사</h2>
<form method="get" action = "146-1_researchTest1.jsp">
	<dl>
		<dd>
			<label for="name">이름: </label>
			<input id="name" name="name" type="text" autofocus required>
		</dd>
		<dd>
			성별: 
			<input id="gender" name="gender" type="radio" value="m" checked>
			<label for="gender">남</label>
			<input id="gender" name="gender" type="radio" value="ㄹ" checked>
			<label for="gender">여</label>
		</dd>
		<dd>
			좋아하는 계절<br/>
			<input id="season" name="season" type="checkbox" value="0">
			<label for="season">봄</label>&nbsp;
			<input id="season" name="season" type="checkbox" value="1">
			<label for="season">여름</label>&nbsp;
			<input id="season" name="season" type="checkbox" value="2">
			<label for="season">가을</label>&nbsp;
			<input id="season" name="season" type="checkbox" value="3">
			<label for="season">겨울</label>&nbsp;
		</dd>
		<dd>
			<input type="submit" value="전송">
		</dd>
	</dl>
</form>

</body>
</html>