<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Jsp First</h1>
	<%
		int a = 10;
		int b = 20;
		int sum = a+b;
		out.println("sum is " + sum);
		out.println("<ul>");
		for(int i=0 ; i<3 ; i++) {
			out.println("<li>" + i + "</li>");
		}
		out.println("</ol>");
	%>
</body>
</html>