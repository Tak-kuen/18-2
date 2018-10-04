<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirectTest</title>
</head>
<body>
<h2>response객체 예제 - sendResponse()메소드의 사용</h2><%-- 출력버퍼에 추가 --%>
현재 페이지는 <b>responseRedirect.jsp</b>페이지입니다.	<%-- 출력버퍼에 추가 --%>
<%response.sendRedirect("153_responseRedirected.jsp"); %>	<%-- 출력버퍼에 추가 --%>
</body>
</html>