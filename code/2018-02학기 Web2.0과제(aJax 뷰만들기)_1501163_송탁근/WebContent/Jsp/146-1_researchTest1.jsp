<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>researchTest1</title>
<% request.setCharacterEncoding("UTF-8"); %>
</head>
<body>
<h2>request 예제 - 요청 메소드</h2>
<%	//request 객체에서 파라미터값을 얻어냄
	String name=request.getParameter("name");
	String gender=request.getParameter("gender");
	String[] season=request.getParameterValues("season");
	//성별값 처리
	if(gender.equals("m"))
		gender="남자";
	else
		gender="여자";
	
	

	for(int i=0; i<season.length;i++) {
		if(season[i].equals("0"))
			season[i]="봄";
		if(season[i].equals("1"))
			season[i]="여름";
		if(season[i].equals("2"))
			season[i]="가을";
		if(season[i].equals("3"))
			season[i]="겨울";
		}
	
%>

<%-- DB연동을 위한 작업 --%>
<%-- 화면 출력 --%>
<%=name%>님의 정보는 다음과 같습니다.<br/><br/>
성별 : <%=gender %><br/>
좋아하는 계절 : 
<% 
for(int i=0; i<season.length-1;i++) {
	out.print(season[i] + ", ");
}
out.print(season[season.length-1]);
%>
</body>
</html>