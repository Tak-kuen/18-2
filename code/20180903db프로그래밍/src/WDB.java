public class WDB {
	public static void main(String[] args) {
		MyDB myObject = new MyDB();
		myObject.connectDB();
		//myObject.insertMember();
		// 조회
		//myObject.select();
		//한 항목에 대한 모든 정보 출력
		//myObject.retrieve(6);
		//myObject.allRetrieve();
		//myObject.printTable();
		//myObject.deleteBookID(6);
		myObject.printTable();
		
		//PrepareStatement를 이용한 쿼리객체 사용
		myObject.insert(9,"Nyyame2"
				+ "","Pub","2018",10000);
		myObject.printTable();
	}
}