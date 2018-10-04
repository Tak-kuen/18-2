<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문과 스트립트릿에서 선언된 변수의 차이</title>
</head>
<body>
<h2>선언문과 스트립트릿에서 선언된 변수의 차이</h2>

<%!
	String str1 = "선언문에서 선언한 변수";
%>
<%
String str2 = "스크리브릿에서 선언한 변수";
%>
<!-- str1은 _jspService()밖에서 생성되었고 str2는 안에서 만들어졌다 -->

</body>
</html>