<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
	<%
	String id= request.getParameter("id");
	String passwd = request.getParameter("passwd");
		
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		String dbUrl="jdbc:mariadb://localhost:3306/test";
		String dbId = "root";
		String dbPw = "1234";
		
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl,dbId,dbPw);
		
		String sql ="select userid,password from member where userid=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,id);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			String rId =rs.getString("userid");
			String rPasswd =rs.getString("password");
			if(id.equals(rId)&&passwd.equals(rPasswd)){
				sql="delete from member where userid = ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,id);
				pstmt.executeUpdate();
				out.println("테이블의 레코드를 삭제했습니다.");
			}else
				out.println("패스워드가 틀렸습니다.");
		}else
			out.println("아이디가 틀렸습니다.");
	}catch(Exception e) {
		e.printStackTrace();
		out.println("변경에 실패");
	}finally {
		if(rs!=null){
			try{rs.close();}catch(SQLException sqle) {}
		}
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