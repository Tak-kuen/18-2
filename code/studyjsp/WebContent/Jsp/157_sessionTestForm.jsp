<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginTest</title>
</head>
<body>
<h2>로그인 테스트</h2>
<%if(session.getAttribute("id")==null){ %>
	<form method="post" action="159_sessionTest.jsp">
	<label for="id">아이디</label>
	<input id="id" name="id" type="text" placeholder="ffesdfes" required><br/>
	<label for="pass">비밀번호</label>
	<input id="pass" name="pass" type="password" placeholder="794613" required>
	<input type="submit" value="로그인">
	</form>
<% }else { %>
	<form method="post" action="160_logout.jsp">
	<%=session.getAttribute("id") %>님 환영합니다.<br>
	<input type="submit" value="로그아웃">
	</form>
<%} %>


</body>
</html>