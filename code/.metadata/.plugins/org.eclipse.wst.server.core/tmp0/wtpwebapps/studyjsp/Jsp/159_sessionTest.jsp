<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionTest</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String id= request.getParameter("id");
	String pass=request.getParameter("pass");
	
	if(id.equals("ffesdfes")&&pass.equals("794613"))
		session.setAttribute("id", id);
	response.sendRedirect("157_sessionTestForm.jsp");
%>

</body>
</html>