package ch11.logon;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

public class LogonDBBean {
	
	//�̱��� DB�� ����
	private static LogonDBBean instance = new LogonDBBean();//������ �ѹ��� �����Ǵ� ��ü
	public static LogonDBBean getInstance() {	return instance;}//
	private LogonDBBean() {}//������ getInstance()�� new�� ���� �Ѵ� ��������
	
	//Ŀ�ؼ�Ǯ���� Ŀ�ؼ� ��ü�� ���� �޼ҵ�
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/test");
		
		return ds.getConnection();
	}
	
	//ȸ������ ó��
	public void insertMember(LogonDataBean member) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("insert into members values(?,?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, member.getReg_date());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getTel());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();	
		} finally {
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try { conn.close();} catch(SQLException ex) {}
		}//try-catch	
	}//insertMember
	
	public int userCheck(String id, String passwd) {	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = -1;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select passwd from members where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					result=1;
				}else
					result=0;//��й�ȣ ����
			//���̵� �����Ұ��
				
			}else
				result=-1;
			//���̵� �������
		} catch (Exception ex) {
			ex.printStackTrace();	
		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try { conn.close();} catch(SQLException ex) {}
		}//try-catch
		
		return result;
	}//userCheck
	
	public int confirmId(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = -1;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select id from members where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1;	//�ߺ����̵� ����
			}else {
				result=-1;	//�ߺ����̵� ����
			}
		} catch (Exception ex) {
			ex.printStackTrace();	
		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try { conn.close();} catch(SQLException ex) {}
		}//try-catch
		
		return result;
	}//confirmId
	
	public LogonDataBean getMember(String id, String passwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		LogonDataBean member=null;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select * from members where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd=rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					member=new LogonDataBean();
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setReg_date(rs.getTimestamp("reg_date"));
					member.setAddress(rs.getString("address"));
					member.setTel(rs.getString("tel"));
				}//��ȸ�� �����͸� �����ͺ� ����
			}
		} catch (Exception ex) {
			ex.printStackTrace();	
		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try { conn.close();} catch(SQLException ex) {}
		}//try-catch
		
		return member;//����� ������ ���� ����
	}//getMember();
	
	public int updateMember(LogonDataBean member) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = -1;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select passwd from members where id=?");
			pstmt.setString(1, member.getId());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(member.getPasswd().equals(dbpasswd)) {
					pstmt=conn.prepareStatement("update members set name=?,address=?,tel=? where id=?");
					pstmt.setString(1, member.getName());
					pstmt.setString(2, member.getAddress());
					pstmt.setString(3, member.getTel());
					pstmt.setString(4, member.getId());
					pstmt.executeUpdate();
					result=1;		//�������� ����
				}else	result=0;	//�������� ����
			}// rs.next
		} catch (Exception ex) {
			ex.printStackTrace();	
		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try { conn.close();} catch(SQLException ex) {}
		}//try-catch
		
		return result;
	}//updateMember
	
	public int deleteMemeber(String id, String passwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = -1;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select passwd from members where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(passwd.equals(dbpasswd)) {
					pstmt=conn.prepareStatement("delete from members where id=?");
					pstmt.setString(1,id);
					pstmt.executeUpdate();
					result=1;		//Ż�� ����
				}else	result=0;	//Ż�� ����
			}//rs.next
		} catch (Exception ex) {
			ex.printStackTrace();	
		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try { conn.close();} catch(SQLException ex) {}
		}//try-catch
		
		return result;
	}//deleteMember
	
}