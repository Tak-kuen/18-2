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
	Cookie [] cookies = request.getCookies();
	if(cookies!=null) {
		for(int i=0; i<cookies.length;i++) {
			if(cookies[i].getName().equals("id")) {
				out.println("쿠키이름 : " + cookies[i].getName());
				out.println("쿠키 값 : " + cookies[i].getValue());
			}// inner if
		}//for
	}//outer if
	else {
		out.println("생성된 쿠키가 없습니다.");
	}
%>
</body>
</html>