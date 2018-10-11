<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스트립트릿 예제 - 로직 사용</title>
</head>
<body>
<h2>스트립트릿 예제 - 로직 사용</h2>
<%
int var1=3;
if(var1>5){
%>
변수 var1의 값은 5보다 크다.
<%} else{%>
변수 var1의 값은 5보다 작거나 같다.
<%}%>
</body>
</html>