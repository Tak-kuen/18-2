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
String throwable = (String)session.getAttribute("throwable");
String[] equipment = (String[])request.getParameterValues("equipment");

switch(category) {
case "ar":
	category="돌격소총";	break;
case "sr":
	category="저격소총";	break;
case "dmr":
	category="지정사수소총";	break;
case "smg":
	category="기관단총";	break;
case "sg":
	category="샷건";	break;
case "etc":
	if(mainWeapon.equals("DP-28")||mainWeapon.equals("M249")){
		category="경기관총";	break;
	}
	else{
		category="기타";	break;
	}
}
switch(throwable) {
case "hand":
	throwable="수류탄"; break;
case "flash":
	throwable="섬광탄";	break;
case "smoke":
	throwable="연막탄";	break;
case "fire":
	throwable="화염병";	break;
}
int equipNo=0;
if(equipment!=null) {
	for(int i=0; i<equipment.length;i++) {
		if(equipment[i].equals("helmet")){
			equipment[i]="헬멧";	equipNo++;}
		if(equipment[i].equals("vest")){
			equipment[i]="방탄조끼";	equipNo++;}
		if(equipment[i].equals("bag")){
			equipment[i]="배낭";	equipNo++;}
	}
}

%>
<h3>Simulator 결과</h3>
당신이 선택한 주 무기는 <%=category%>-<%=mainWeapon%>입니다.<br/>
당신이 선택한 보조무기는 <%=subWeapon%>, 투척무기는 <%=throwable%>입니다.<br/>
당신이 착용하고 있는 장비는 <%
if(equipment==null) { 
	out.print("없습니다.");
}else {
	for(int i=0; i<equipment.length-1;i++) 
	out.print(equipment[i] + ", ");
	out.print(equipment[equipment.length-1]);
	out.print("이며, "+ equipNo + "개입니다.");
}
%><br/>
<form action="6_retry.jsp" method="post">
	<input type="submit" value="Restart">
</form>
</body>
</html>