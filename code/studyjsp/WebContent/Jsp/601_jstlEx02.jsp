<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL test</title>
</head>
<body>
	<c:set var="df" value="2" />	<!-- //변수이름 name, 변수값 value-->
	${1+1}			<!--표현언어 : 단순한 값출력뿐 아니라 계산 및 널체크까지 해줌  -->
	<c:set var="country" value="${'Korea'}"/>
	<c:if test="${country != null}">
		국가명 : ${country}<br>
	</c:if>
	
	<c:choose>
		<c:when test="${country== 'Korea' }">
			<p><c:out value="${country}"/>의 겨울은 춥다.
		</c:when>
		<c:when test="${country== 'Canada' }">
			<p><c:out value="${country}"/>의 겨울은 너무 춥다.
		</c:when>
		<c:otherwise>
			<p>그외의 나라들의 겨울은 알 수 없다.
		</c:otherwise>
	</c:choose>
	
	

</body>
</html>