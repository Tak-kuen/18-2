<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
<style>
table, tr, td{
border : 1px solid skyblue;
border-collapse:collapse;
}
</style>

<%String contentPage=request.getParameter("contentPage"); %>
<table>
	<tr>
		<td colspan="2">
		<jsp:include page="186-2_top.jsp"/>
		</td>
	</tr>
	<tr>
		<td width="150" valign="top">
			<jsp:include page="186-1_left.jsp" flush="false"/>
		</td>
		<td width="350" valign="top">
			<jsp:include page="<%=contentPage%>" flush="false"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<jsp:include page="187-2_bottom.jsp" flush="false"/>
		</td>
	</tr>
</table>

</body>
</html>