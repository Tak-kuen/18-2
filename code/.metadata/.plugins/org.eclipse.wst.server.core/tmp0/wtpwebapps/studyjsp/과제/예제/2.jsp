<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예제</title>
</head>
<body>
<h2>성별을 선택하세요</h2>
<%--form에서 입력하는것은 parameter이고 그 외에는 모두 attribute로 저장 --%>
<%--session에서 attribute로 저장한것은 페이지 넘어다니는것이고,
request에서 attribute로 받는것은 포워딩 했을때만 가능 --%>
<%
request.setCharacterEncoding("utf-8");
session.setAttribute("name",request.getParameter("name"));
%>
<form action="3.jsp" method="get">
성별<br/>
<input type="radio" name="gender" id="gender" value="m">
<label for="gender">남</label>
<input type="radio" name="gender" id="gender" value="f">
<label for="gender">여</label><br/>
<input type="submit" value="입력 완료">
</form>

</body>
</html>