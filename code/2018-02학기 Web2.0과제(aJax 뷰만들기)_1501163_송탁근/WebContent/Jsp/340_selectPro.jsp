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
	<table>
		<tr>
			<td>아이디</td>
			<td>비빌번호</td>
			<td>이름</td>
		</tr>
		
		<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			String dbUrl="jdbc:mariadb://localhost:3306/test";
			String dbId = "root";
			String dbPw = "1234";
			
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl,dbId,dbPw);
			
			String sql="select * from member order by userid desc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id=rs.getString("userid");
				String passwd = rs.getString("password");
				String name=rs.getString("username");
				
		%>
				<tr>
					<td><%=id %></td>
					<td><%=passwd %></td>
					<td><%=name %></td>
				</tr>
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