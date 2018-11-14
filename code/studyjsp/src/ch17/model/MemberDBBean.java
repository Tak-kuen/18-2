package ch17.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDBBean {
	
	private static MemberDBBean instance = new MemberDBBean();//무조건 한번은 생성되는 객체
	public static MemberDBBean getInstance() {	return instance;}//
	private MemberDBBean() {}//없으면 getInstance()와 new로 생성 둘다 가능해짐
	
	//커넥션풀에서 커넥션 객체를 얻어내는 메소드
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/test");
		
		return ds.getConnection();
	}
	
	public ArrayList<Member> browseMember() {
		ArrayList<Member> list=null;
		Member bean;
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select * from members");
			rs=pstmt.executeQuery();
			list=new ArrayList<>();
			while(rs.next()) {
				bean=new Member();
				bean.setName(rs.getString("name"));
				bean.setId(rs.getString("id"));
				bean.setAddress(rs.getString("address"));
				list.add(bean);
			}
		} catch (Exception ex) {
			ex.printStackTrace();	
		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try { conn.close();} catch(SQLException ex) {}
		}//try-catch
		
		return list;
	}
}
