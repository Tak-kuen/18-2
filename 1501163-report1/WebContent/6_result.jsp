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
String category= (String)session.getAttribute("category");
String mainWeapon = (String)session.getAttribute("mainWeapon");
String subWeapon = (String)session.getAttribute("subWeapon");
String[] equipment = (String[])request.getParameterValues("equipment");

for(int i=0; i<equipment.length;i++) {
	if(equipment[i].equals("helmet"))
		equipment[i]="헬멧";
	if(equipment[i].equals("vest"))
		equipment[i]="방탄조끼";
	if(equipment[i].equals("bag"))
		equipment[i]="배낭";
}
%>
당신이 선택한 주 무기의 분류는 <%=category%>입니다.<br/>
당신이 선택한 주 무기는 <%=mainWeapon%>입니다.<br/>
당신이 선택한 보조무기는 <%=subWeapon%>입니다.<br/>
당신이 착용하고 있는 장비는 <%
for(int i=0; i<equipment.length-1;i++) 
out.print(equipment[i] + ", ");
out.print(equipment[equipment.length-1]);
%>입니다.
</body>
</html>