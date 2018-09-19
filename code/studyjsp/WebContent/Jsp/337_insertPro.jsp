<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>

	<%
		String id= request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String str="";
		
		try {
			String dbUrl="jdbc:mariadb://localhost:3306/test";
			String dbId = "root";
			String dbPw = "1234";
			
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl,dbId,dbPw);
			
			String sql ="insert into member values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,passwd);
			pstmt.setString(3,name);
			pstmt.executeUpdate();
			
			out.print("성공적으로 쿼리가 실행되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			out.println("쿼리 실행에 실패했습니다.");
		} finally{
			if(pstmt!=null){
				try{pstmt.close();}catch(SQLException sqle){}
			}
			if(conn!=null) {
				try{conn.close();} catch(SQLException sqle){}
			}
		}
	%>
</body>
</html>