import java.sql.SQLException;

public class WDB {
	public static void main(String[] args) {
		Test test=new Test();
		//test.divideByZero();
		//test.ArrayIndexOutOf();
		test.getBookList();
		
		try {
			test.getBookListThrow();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
