import java.sql.*;

class MyDB {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	
	// 데이터베이스에 연결
	public void connectDB() {
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
					this.conn=DriverManager.getConnection(url, id, pw);
					System.out.println("DB연결에 성공했습니다.");
				} catch (SQLException e) {
					System.out.println("DB연결에 실패했습니다.");
					return;
				}
	}
	
	public void insertMember() {
		// 5,'Power JAVA', 'YJU', '2018',20000
		//1.Statement 객체를 생성
		try {
			this.stmt=this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement 객체 생성에 문제가 있네요..");
		}
		//2.SQL문장 작성
		String sql = "insert into books(book_id, title, publisher,year, price)"
				+ "values(6,'Do it! 웹사이트 기획 입문', 'YJU', '2018',23000)";
		System.out.println(sql);
		//3.DB에서 실행
		try {
			int n = stmt.executeUpdate(sql);
			System.out.println("결과에 반영된 열의 수는 " + n);
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL실행에 문제가 있네요..");
		}
		
	
	
	}

	public void select() {
		try {
			this.stmt=this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement 객체 생성에 문제가 있네요..");
		}
		
		String sql = "select * from books";
		try {
			this.rs=this.stmt.executeQuery(sql);
			
			while(rs.next()) {
				String title = rs.getString("title");
				System.out.println(title);
			}
		} catch (SQLException e) {
			
		}
	}
}
