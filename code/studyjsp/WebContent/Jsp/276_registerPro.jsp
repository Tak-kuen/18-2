<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id="registerBean" class="ch08.register._274_RegisterBean">
		<jsp:setProperty name="registerBean" property="*"/>
	</jsp:useBean>
	
	<% registerBean.setReg_date(new Timestamp(System.currentTimeMillis())); %>
	
	<table>
		<tr>
			<td>아이디
			<td><jsp:getProperty name="registerBean" property="id"/>
		</tr>
		<tr>
			<td>비밀번호
			<td><jsp:getProperty name="registerBean" property="passwd"/>
		</tr>
		<tr>
			<td>이름
			<td><jsp:getProperty name="registerBean" property="name"/>
		</tr>
		<tr>
			<td>가입일
			<td><jsp:getProperty name="registerBean" property="reg_date"/>
		</tr>
	</table>

</body>
</html>