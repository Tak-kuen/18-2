<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<%-- jstl 사용하면 import 할 필요도 없어진다! 372_todo.jsp와 비교해 보자 --%>
	<%-- <c:if test="${empty productList}"> 왼쪽은 널체크시 간단한 구문
	있을때는 not empty사용 아래는 띄어쓰기 구분--%>
	<c:if test="${productList == null}">
	등록된 상품이 없습니다.
	</c:if>
	<c:if test="${productList != null}">
		<form>
			<c:forEach var="p" items="${productList}">
			<input type="checkbox" name="selected" value="${p.id }"/>
			${p.name},&nbsp; ${p.info},&nbsp; ${p.price}<br/>
			</c:forEach>
		</form>
	</c:if>
</body>
</html>