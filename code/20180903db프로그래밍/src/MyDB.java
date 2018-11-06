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
			
			//커서를 옮겨주는 next메소드를 사용
			while(rs.next()) {
				String title = rs.getString("title");
				System.out.println(title);
			}
		} catch (SQLException e) {
			
		}
	}

	public void retrieve(int n) {
		//1.statement객체 생성
		try {
			this.stmt=this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement 객체 생성에 문제가 있네요..");
		}
		//2.sql 작성
		String sql = "select * from books";
		//3.쿼리 실행 및 결과 반환
		try {
			this.rs=this.stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Query실행중 문제가 일어났네요..");
		}
		//4.결과를 원하는 형태로 출력
		try {
			for(int i=0 ;i<n;i++) {
				rs.next();
			}
			//DB스키마에서 값을불러올때 DB에서 설정한 데이터 형과 같아야한다.
			//(year는 varchar2이므로 String으로 불러와야 한다.
 				int bookID = rs.getInt(1);
				String bookname = rs.getString(2);
				String publisher = rs.getString(3);
				String year = rs.getString(4);
				int price = rs.getInt(5);
			
			System.out.println(bookID + ", " + bookname + ", " + publisher + ", " + year + ", " + price);
		} catch (SQLException e) {
			System.out.println("결과처리중 문제가 일어났네요..");
		}
	}

	public void allRetrieve() {
		//1.statement객체 생성
				try {
					this.stmt=this.conn.createStatement();
				} catch (SQLException e) {
					System.out.println("Statement 객체 생성에 문제가 있네요..");
				}
				//2.sql 작성
				String sql = "select * from books";
				//3.쿼리 실행 및 결과 반환
				try {
					this.rs=this.stmt.executeQuery(sql);
				} catch (SQLException e) {
					System.out.println("Query실행중 문제가 일어났네요..");
				}
				//4.결과를 원하는 형태로 출력
				try {
					
					while(rs.next()) {
					//DB스키마에서 값을불러올때 DB에서 설정한 데이터 형과 같아야한다.
					//(year는 varchar2이므로 String으로 불러와야 한다.
		 				int bookID = rs.getInt(1);
						String bookname = rs.getString(2);
						String publisher = rs.getString(3);
						String year = rs.getString(4);
						int price = rs.getInt(5);
					
					System.out.println(bookID + ", " + bookname + ", " + publisher + ", " + year + ", " + price);
					}
				} catch (SQLException e) {
					System.out.println("결과처리중 문제가 일어났네요..");
				}
				
				
		
	}

	public void printTable() {
		//1.statement객체 생성
		try {
			this.stmt=this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement 객체 생성에 문제가 있네요..");
		}
		//2.sql 작성
		String sql = "select * from books order by title";
		//3.쿼리 실행 및 결과 반환
		try {
			this.rs=this.stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Query실행중 문제가 일어났네요..");
		}
		//4.결과를 원하는 형태로 출력
		try {
			
			while(rs.next()) {
			//DB스키마에서 값을불러올때 DB에서 설정한 데이터 형과 같아야한다.
			//(year는 varchar2이므로 String으로 불러와야 한다.
 				int bookID = rs.getInt(1);
				String bookname = rs.getString(2);
				String publisher = rs.getString(3);
				String year = rs.getString(4);
				int price = rs.getInt(5);
			
			System.out.printf("%d || %-25s || %-13s || %4s || %6d%n",bookID,bookname,publisher,year,price);
			}
		} catch (SQLException e) {
			System.out.println("결과처리중 문제가 일어났네요..");
		}
		
		
	}

	public void deleteBookID(int bookID) {
		//1.Statement 객체를 생성
		try {
			this.stmt=this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement 객체 생성에 문제가 있네요..");
		}
		//2.SQL문장 작성
		String sql = "delete from books where book_id =" +bookID;
		
		//3.DB에서 실행
		try {
			int n = stmt.executeUpdate(sql);
			System.out.println("결과에 반영된 열의 수는 " + n);
		} catch (SQLException e) {
			System.out.println("SQL실행에 문제가 있네요..");
		}
		
	}

	public void insert(int id, String name, String pub, String year, int price) {
		//1.SQL문장 작성
		String sql = "insert into books(book_id, title, publisher,year, price)"
				+ "values(?,?,?,?,?)";
		System.out.println(sql);
		//2.PreparedStatement 객체 생성
		PreparedStatement pstmt=null;
		try {
			pstmt=this.conn.prepareStatement(sql);
		//3.매개변수 대입
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pub);
			pstmt.setString(4, year);
			pstmt.setInt(5, price);
		} catch (SQLException e) {
			System.out.println("Statement 객체 생성에 문제가 있네요..");
			return;
		}
		//3.DB에서 실행
		try {
			int n = pstmt.executeUpdate();
			System.out.println("결과에 반영된 열의 수는 " + n);
		} catch (SQLException e) {
			System.out.println("SQL실행에 문제가 있네요..");
		}
	}
}
