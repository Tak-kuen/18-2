
public class WDB {
	public static void main(String[] args) {
		MyDB myObject = new MyDB();
		myObject.connectDB();
		//myObject.insertMember();
		// ��ȸ
		myObject.select();
	}
}
