import java.sql.*;
import java.util.Scanner;

class Test {
	
	void divideByZero() {
		int x,y;
		Scanner input = new Scanner(System.in);
		
		System.out.print("나누어지는 수 : " );
		x = input.nextInt();
		
		System.out.print("나누는 수 : ");
		y = input.nextInt();
		
		try {
		int result=x/y;
		} catch(Exception e) {
			System.out.println("예외를 처리");
		} finally {
			System.out.println("ㄹㄹ");
		}
		System.out.println("정상 실행");
	}
	
	void ArrayIndexOutOf() {
		int[] array = {1,2,3,4,5};
		int i=0;
		try {
			for(i=0; i<array.length+1; i++) {
				System.out.println(array[i] + " ");
			}
		} catch (Exception e) {
			System.out.println(i + "인덱스는 처리할수 없습니다.");
		}
	}
	
	void getBookList() {
		//1. 드라이버 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			return;
		} 
		System.out.println("드라이버 정상적으로 적재함");
		
		//2. 연결
		String url="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String user="s1501163";
		String password="p1501163";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("DB에 연결할 수 없네요");
		}
		System.out.println("DB연결 완료");
		//3. Statement 객체 생성
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement객체를 생성할 수 없습니다.");
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		//4. 쿼리 실행 및 결과 반환
		
		String sql="select * from books";
		try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("쿼리를 실행할 수 없습니다.");
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		//5. 결과 처리
		try {
			while(rs.next()) {
				String bookName=rs.getString(2);
				System.out.println(bookName);
			}
		} catch (SQLException e) {
			System.out.println("커서에 문제가있습니다");
		}finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//6.
	}
	void getBookListThrow() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String user="s1501163";
		String password="p1501163";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		conn=DriverManager.getConnection(url, user, password);
		stmt=conn.createStatement();
		String sql="select * from books";
		rs=stmt.executeQuery(sql);
		while(rs.next()) {
			String bookName=rs.getString(2);
			System.out.println(bookName);
		}
		rs.close();
		conn.close();
	}
}