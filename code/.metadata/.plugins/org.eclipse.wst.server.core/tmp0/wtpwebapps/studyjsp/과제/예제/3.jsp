<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예제</title>
</head>
<body>
<h2>결과창</h2>
<%
request.setCharacterEncoding("utf-8");
String name=(String)session.getAttribute("name");
String gender=request.getParameter("gender");

if(gender.equals("m"))
	gender="남자";
else
	gender="여자";
%>
이름은 <%=name %>이고, 성별은 <%=gender %>입니다.
</body>
</html>