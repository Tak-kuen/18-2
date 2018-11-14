<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
	<h2>이름으로 물품검색</h2>
	<form action="ProductSearchServlet" method="post">
	이름 : <input type="text" name="name" >
	<input type="submit" value="검색">
	</form>
	<hr/>
	<c:if test="${productList == null}">
	등록된 상품이 없습니다.
	</c:if>
	<c:if test="${productList != null}">
			<c:forEach var="p" items="${productList}">
			검색어&nbsp;:&nbsp;${p.name}<br/>
			결과<br/>
			${p.id }&nbsp;:&nbsp;${p.name}&nbsp; ${p.info}&nbsp; ${p.price}<br/>
			</c:forEach>
	</c:if>
</body>
</html>