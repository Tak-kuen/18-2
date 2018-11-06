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
	<table>
		<tr>
			<td>아이디
			<td>비밀번호
			<td>이름
		<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/test");
			conn= ds.getConnection();
			
			String sql="select * from member";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id=rs.getString("userid");
				String passwd=rs.getString("password");
				String name=rs.getString("username");
	
		%>
			<tr>
				<td><%=id %>
				<td><%=passwd %>
				<td><%=name %>
		<%	}
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
	</table>

</body>
</html>