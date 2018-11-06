import java.sql.*;

public class WDB {

	public static void main(String[] args) {
		//1. JDBC드라이버 적재
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			return;
		}	
		
		//2. 데이터베이스 연결
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1501163";
		String pw = "p1501163";
		try {
			DriverManager.getConnection(url, id, pw);
			System.out.println("DB연결에 성공했습니다.");
		} catch (SQLException e) {
			System.out.println("DB연결에 실패했습니다.");
			return;
		}
		//3. 데이터베이스 연결 종료

	}

}
