<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<style>
		ul {
			list-style:none;
		}
	</style>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
	
	<h2>할일 리스트 생성 및 조회</h2>
	<h3>추가하기</h3>
	<form action = "TodoServlet" method="post">
		할일 : <input type="text" name="detail" ><input type="submit" value="추가하기"><br/>
	</form>
	<h3>조회하기</h3>
	<ul>
	<c:if test="${todoList != null}">
		<c:forEach var="list" items="${todoList}">
			<li>${list.detail}</li>
		</c:forEach>
	</c:if>
	</ul>
	

</body>
</html>