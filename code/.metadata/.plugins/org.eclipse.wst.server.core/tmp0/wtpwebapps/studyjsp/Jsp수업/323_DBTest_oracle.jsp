<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Connection conn;
	Statement stmt;
	ResultSet rs;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버를 찾을 수 없습니다.");
	//2. 데이터베이스 연결
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1501163";
		String pw = "p1501163";
		conn=DriverManager.getConnection(url, id, pw);
		out.println("DB연결에 성공했습니다.");
		conn.close();
	} catch (Exception e) {
		out.println(e);
	}
%>


</body>
</html>