<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
<% 
String category = (String)session.getAttribute("category");
if(category.equals("ar")){
	String mainWeapon = request.getParameter("ar");
	session.setAttribute("mainWeapon",mainWeapon);
}
if(category.equals("sr")){
	String mainWeapon = request.getParameter("sr");
	session.setAttribute("mainWeapon",mainWeapon);
}
if(category.equals("dmr")){
	String mainWeapon = request.getParameter("dmr");
	session.setAttribute("mainWeapon",mainWeapon);
}
if(category.equals("smg")){
	String mainWeapon = request.getParameter("smg");
	session.setAttribute("mainWeapon",mainWeapon);
}
if(category.equals("sg")){
	String mainWeapon = request.getParameter("sg");
	session.setAttribute("mainWeapon",mainWeapon);
}
if(category.equals("etc")){
	String mainWeapon = request.getParameter("etc");
	session.setAttribute("mainWeapon",mainWeapon);
}
response.sendRedirect("4_subWeaponSelect.jsp");

%>



</body>
</html>