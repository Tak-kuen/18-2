<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoTest</title>
</head>
<body>
<%= request.getParameter("age") %>세이고, <%
String result = (String)request.getAttribute("result");
String[] test = (String[])request.getAttribute("test");
%>
<%=result %>
<%=test[0] %>

</body>
</html>