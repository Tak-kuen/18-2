<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
<h2>PUBG Weapon Simulator</h2>
<h3>주무기 분류를 선택해 주세요.</h3>

<form action="weaponSelect.jsp" method="get">
<input name="category" type="radio" value="ar" >Automatic Rifle<br/>
<input name="category" type="radio" value="sr">Sniper Rifle<br/>
<input name="category" type="radio" value="dmr">Designated Marksman's Rifle<br/>
<input name="category" type="radio" value="smg">Submachine Gun<br/>
<input name="category" type="radio" value="sg">Shotgun<br/>
<input name="category" type="radio" value="etc">Etc<br/>
<br/>
<input type="submit" value="Next">

</form>
</body>
</html>