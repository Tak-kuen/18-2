<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
<h3>주무기를 선택해주세요</h3>
<form action ="3_subWeaponSelect.jsp" method="get">

<fieldset style="width: 300px;">
<legend align=center>주무기</legend>
<% 
String ctgr=request.getParameter("category");
session.setAttribute("category", ctgr);
if(ctgr.equals("ar")) {%>
<input type="radio" name="ar" value="M16A4">M16A4<br/>
<input type="radio" name="ar" value="M416">M416<br/>
<input type="radio" name="ar" value="SCAR-L">SCAR-L<br/>
<input type="radio" name="ar" value="AUG">AUG<br/>
<input type="radio" name="ar" value="QBZ">QBZ<br/>
<input type="radio" name="ar" value="AKM">AKM<br/>
<input type="radio" name="ar" value="Groza">Groza<br/>
<input type="radio" name="ar" value="Beryl M762">Beryl M762<br/>
<%}
if(ctgr.equals("dmr")){%>
<input type="radio" name="dmr" value="SKS">SKS<br/>
<input type="radio" name="dmr" value="VSS">VSS<br/>
<input type="radio" name="dmr" value="Mini-14">Mini-14<br/>
<input type="radio" name="dmr" value="SLR">SLR<br/>
<input type="radio" name="dmr" value="Mk14">Mk14<br/>
<input type="radio" name="dmr" value="QBU">QBU<br/>
<%}
if(ctgr.equals("sr")) {%>
<input type="radio" name="sr" value="Kar98k">Kar98k<br/>
<input type="radio" name="sr" value="M24">M24<br/>
<input type="radio" name="sr" value="AWM">AWM<br/>
<%}
if(ctgr.equals("smg")) {%>
<input type="radio" name="smg" value="Micro UZI">Micro UZI<br/>
<input type="radio" name="smg" value="UMP9">UMP9<br/>
<input type="radio" name="smg" value="Tommy Gun">Tommy Gun<br/>
<input type="radio" name="smg" value="Vector">Vector<br/>
<%}
if(ctgr.equals("sg")) {%>
<input type="radio" name="sg" value="S1897">S1897<br/>
<input type="radio" name="sg" value="S686">S686<br/>
<input type="radio" name="sg" value="S12K">S12K<br/>
<%}
if(ctgr.equals("etc")) {%>
<input type="radio" name="etc" value="DP-28">DP-28<br/>
<input type="radio" name="etc" value="M249">M249<br/>
<input type="radio" name="etc" value="Crossbow">Crossbow<br/>
<input type="radio" name="etc" value="Win94">Win94<br/>
<%} %>
</fieldset>
<br/>
<input type="submit" value="Subweapon">
</form>

</body>
</html>