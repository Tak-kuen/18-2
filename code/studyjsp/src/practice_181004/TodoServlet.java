package practice_181004;

import java.io.IOException;
import java.sql.*;
import javax.sql.*;

import javafx.animation.SequentialTransitionBuilder;

import javax.naming.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		session.setAttribute("todoList", getList());
		request.getRequestDispatcher("Jsp/372_todo.jsp").forward(request,response);
		//������ ���� ��������� �Ѵ�.
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String detail=request.getParameter("detail");
		addList(detail);
		HttpSession session= request.getSession();
		session.setAttribute("todoList", getList());
		request.getRequestDispatcher("Jsp/372_todo.jsp").forward(request,response);
	}
	
	private ArrayList<TodoBean> getList() {
		ArrayList<TodoBean> list =null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/test");
			conn= ds.getConnection();
			
			list=new ArrayList<>();
			
			String sql="select * from todo";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				TodoBean bean=new TodoBean();
				bean.setId(rs.getInt("id"));
				bean.setDetail(rs.getString("detail"));
				bean.setDone(rs.getBoolean("done"));
				list.add(bean);
			}//while
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
		
		return list;
	}	//getList()
	
	private int addList(String detail) {
		int result =0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/test");
			conn= ds.getConnection();
			String sql="insert into todo (detail) values (?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, detail);
			result=pstmt.executeUpdate();
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
		}	//final
		return result;
	}

}
