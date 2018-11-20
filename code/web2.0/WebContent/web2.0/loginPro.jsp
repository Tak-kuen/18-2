<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.*,java.sql.*,javax.sql.*"%>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

JSONObject jsonObject;
JSONArray jsonArray = new JSONArray();

Connection conn = null;
ResultSet rs = null;
PreparedStatement pstmt = null;	

String id=request.getParameter("id");
String passwd=request.getParameter("passwd");

try {
	String url="jdbc:mariadb://localhost:3306/test";
	String dbid = "root";
	String dbpw = "1234";
	

	Class.forName("org.mariadb.jdbc.Driver");
	conn = DriverManager.getConnection(url, dbid, dbpw);
	pstmt=conn.prepareStatement("select * from member where mid=?");
	pstmt.setString(1, id);
	rs=pstmt.executeQuery();
	
	if(rs.next()) {
		String dbpasswd = rs.getString("mpw");
		if(dbpasswd.equals(passwd)) {
			jsonObject = new JSONObject();
			jsonObject.put("mno", rs.getInt("mno"));
			jsonObject.put("mname", rs.getString("mname"));
			jsonObject.put("mid",id);
			jsonObject.put("mid",passwd);
			jsonArray.put(jsonObject);
			out.print(jsonArray);
		}else
			out.print(0);
	//아이디가 존재할경우
	}else
		out.print(-1);
	//아이디가 없을경우
} catch (Exception ex) {
	ex.printStackTrace();
} finally {
	if(rs!=null) try { rs.close();} catch(SQLException ex) {}
	if(pstmt!=null) try { pstmt.close();} catch(SQLException ex) {}
	if(conn!=null) try { conn.close();} catch(SQLException ex) {}
}//try-catch

%>