<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
<h3>장비를 선택해주세요</h3>
<%
String subWeapon = request.getParameter("sub");
session.setAttribute("subWeapon",subWeapon);
%>
<form action="6_result.jsp" method="post">
<input type="checkbox" name="equipment" value="helmet">헬멧<br/>
<input type="checkbox" name="equipment" value="vest">방탄조끼<br/>
<input type="checkbox" name="equipment" value="bag">배낭<br/>
<br/>
<input type="submit" value="결과 확인">


</form>
</body>
</html>