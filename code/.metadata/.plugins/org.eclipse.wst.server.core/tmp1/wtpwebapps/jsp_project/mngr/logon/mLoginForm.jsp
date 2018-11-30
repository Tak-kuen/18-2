<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/NewFile.css" type="text/css" />
<link rel="stylesheet" href="/jsp_project/css/style.css"/>
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<script src="/jsp_project/mngr/logon/mLogin.js"></script>
<meta charset="UTF-8">
<title>mLoginForm</title>
</head>
<body>
	<c:if test="${empty sessionScope.id}">
		<div class="status">
			<ul>
			<h1>Log-in</h1>
				<dl>ID <input id="id" name="id" type="email" size="20" maxlength="50"></dl>
				<dl>PW <input id="passwd" name="passwd" type="password" size="20" maxlength="16"></dl>
				<button id="login">로그인</button>
			</ul>
		</div>
	</c:if>
	<c:if test="${not empty sessionScope.id }">
		<div id="status">
			<ul>
				<li>관리자 로그인 성공!!.. 작업중
				<button id="logout">로그아웃</button>
			</ul>
		</div>
	</c:if>
</body>
</html>