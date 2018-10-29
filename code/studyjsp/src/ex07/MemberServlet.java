package ex07;

import java.io.IOException;
import java.sql.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter()�� �������� jsp�� out�̴�
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		response.getWriter().print(login(userid,password));
	}
	
	private int login(String userid, String password) {
		int result=0;	//1:����, 0:���Ʋ��, -1:���̵� ����
		//DBCP�� �̿��� ������� id�� �̿��ؼ� �˻�
		String dbId;
		String dbPass;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/test");
			conn= ds.getConnection();
			
			String sql="select * from member where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dbId=rs.getString("userid");
				dbPass=rs.getString("password");
				if(dbId.equals(userid)&&dbPass.equals(password)) { 
					result=1;
				} else {
					result=0;
				}//if-else ���̵�� ������
			} else {
				result=-1;
			}//if-else rs.next()
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
		}//try-catch
		return result;
	}

}