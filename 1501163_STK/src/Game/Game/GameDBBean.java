package Game;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GameDBBean {
	private int result=0;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private Connection conn=null;
	private static GameDBBean instance = new GameDBBean();
	public static GameDBBean getInstance() { return instance;}
	private GameDBBean() {}
	
	public Connection connectDB() {
		String url = "jdbc:mariadb://localhost:3306/test";
		String dbId = "root";
		String dbPw = "1234";
		//1. JDBC드라이버 적재
				try {
					Class.forName("org.mariadb.jdbc.Driver");
					System.out.println("드라이버 적재 성공");
					return DriverManager.getConnection(url, dbId, dbPw);
				} catch(ClassNotFoundException | SQLException e) {
					System.out.println("드라이버를 찾을 수 없습니다.");
					return null;
				}	
		//2. 데이터베이스 연결
	}
	public int checkDB(String id) {
		conn=connectDB();
		try {
			pstmt=conn.prepareStatement("select * from user where userid=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "로그인 확인");
				result=1;
				
			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
				result=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertScore(String time, String id) {
		conn=connectDB();
		int x=0;
		try {
			pstmt=conn.prepareStatement("insert into score(time,userid) values(?,?)");
			pstmt.setString(1, time);
			pstmt.setString(2, id);
			x=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	public ArrayList<ScoreBean> idScore(String id) {
		ArrayList<ScoreBean> scoreList=null;
		ScoreBean bean;
		conn=connectDB();
		int x=0;
		try {
			scoreList=new ArrayList<>();
			pstmt=conn.prepareStatement("select time,userid from score where userid=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bean=new ScoreBean();
				bean.setTime(rs.getString("time"));
				bean.setUserid(rs.getString("userid"));
				scoreList.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scoreList;
	}
	
	public ArrayList<ScoreBean> getRank(String id) {
		ArrayList<ScoreBean> rankList=null;
		ScoreBean bean;
		conn=connectDB();
		int x=0;
		try {
			 rankList=new ArrayList<>();
			pstmt=conn.prepareStatement("select time,userid from score order by time");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bean=new ScoreBean();
				bean.setTime(rs.getString("time"));
				bean.setUserid(rs.getString("userid"));
				rankList.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rankList;
	}
}
