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
%>
<h2>보조무기를 선택해주세요</h2>
<form action="4_equipmentSelect.jsp" method="post">
<fieldset style="width: 300px;">
<legend align=center>보조무기</legend>
<input type="radio" name="sub" value="P92">P92<br/>
<input type="radio" name="sub" value="P1911">P1911<br/>
<input type="radio" name="sub" value="P18C">P18C<br/>
<input type="radio" name="sub" value="R1895">R1895<br/>
<input type="radio" name="sub" value="R45">R45<br/>
<input type="radio" name="sub" value="Sawed-off">Sawed-off<br/>
</fieldset>
<br/>
<fieldset style="width: 300px;">
<legend align=center>투척무기</legend>
<input type="radio" name="thr" value="hand">수류탄<br/>
<input type="radio" name="thr" value="flash">섬광탄<br/>
<input type="radio" name="thr" value="smoke">연막탄<br/>
<input type="radio" name="thr" value="fire">화염병<br/>
</fieldset>
<br/>
<input type="submit" value="Equipment">
<%
%>
</form>
</body>
</html>