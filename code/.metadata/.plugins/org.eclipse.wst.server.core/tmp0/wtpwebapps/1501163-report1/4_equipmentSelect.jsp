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
String throwable = request.getParameter("thr");
session.setAttribute("subWeapon",subWeapon);
session.setAttribute("throwable",throwable);
%>
<form action="5_result.jsp" method="post">
<fieldset style="width: 300px;">
<legend align=center>장비</legend>
<input type="checkbox" name="equipment" value="helmet">헬멧<br/>
<input type="checkbox" name="equipment" value="vest">방탄조끼<br/>
<input type="checkbox" name="equipment" value="bag">배낭<br/>
</fieldset>
<br/>
<input type="submit" value="결과 확인">


</form>
</body>
</html>