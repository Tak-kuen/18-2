<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String logId= request.getParameter("id");
	String logPass=request.getParameter("pass");
	String dbPass;
	String dbId;
	
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/test");
		conn= ds.getConnection();
		
		String sql="select userid,password from member where userid=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,logId);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			dbId=rs.getString("userid");
			dbPass=rs.getString("password");
			if(dbId.equals(logId)&&dbPass.equals(logPass)) { 
			out.println("welcome");
			} else {
				out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			out.println("아이디가 틀렸습니다.");
		}
	}catch(Exception e) {
		e.printStackTrace();
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