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
<form action ="3_savingPage.jsp" method="get">
<% 
String ctgr=request.getParameter("category");
session.setAttribute("category", ctgr);
if(ctgr.equals("ar")) {%>
<input type="radio" name="ar" value="m16">M16A4<br/>
<input type="radio" name="ar" value="m4">M416<br/>
<input type="radio" name="ar" value="scar">SCAR-L<br/>
<input type="radio" name="ar" value="aug">AUG<br/>
<input type="radio" name="ar" value="qbz">QBZ<br/>
<input type="radio" name="ar" value="ak">AKM<br/>
<input type="radio" name="ar" value="groza">Groza<br/>
<input type="radio" name="ar" value="beryl">Beryl M762<br/>
<%}
if(ctgr.equals("dmr")){%>
<input type="radio" name="dmr" value="sks">SKS<br/>
<input type="radio" name="dmr" value="vss">VSS<br/>
<input type="radio" name="dmr" value="mini">Mini-14<br/>
<input type="radio" name="dmr" value="slr">SLR<br/>
<input type="radio" name="dmr" value="mk">Mk14<br/>
<input type="radio" name="dmr" value="qbu">QBU<br/>
<%}
if(ctgr.equals("sr")) {%>
<input type="radio" name="sr" value="kar">Kar98k<br/>
<input type="radio" name="sr" value="m24">M24<br/>
<input type="radio" name="sr" value="awm">AWM<br/>
<%}
if(ctgr.equals("smg")) {%>
<input type="radio" name="smg" value="uzi">Micro UZI<br/>
<input type="radio" name="smg" value="ump">UMP9<br/>
<input type="radio" name="smg" value="tommy">Tommy Gun<br/>
<input type="radio" name="smg" value="vec">Vector<br/>
<%}
if(ctgr.equals("sg")) {%>
<input type="radio" name="sg" value="pump">S1897<br/>
<input type="radio" name="sg" value="dub">S686<br/>
<input type="radio" name="sg" value="saiga">S12K<br/>
<%}
if(ctgr.equals("etc")) {%>
<input type="radio" name="etc" value="dp">DP-28<br/>
<input type="radio" name="etc" value="rambo">M249<br/>
<input type="radio" name="etc" value="cross">Crossbow<br/>
<input type="radio" name="etc" value="win">Win94<br/>
<%} %>
<br/>
<input type="submit" value="Subweapon">
</form>

</body>
</html>