package _0918LinearList;
//1501163 송탁근
public class Ex5_3 {
	public static void main(String[] args) {
		int sale[][][]= new int[][][] {{{63,84,140,130},{157,209,251,312}}
		,{{59,80,130,135},{149,187,239,310}}};
		
		for(int i=0; i<sale.length;i++) {
			System.out.printf("<< %d팀 >> %n", i+1);
			for(int j=0; j<sale[0].length;j++) {
				for(int k=0;k<sale[0][0].length;k++) {
					System.out.printf("%d/4분기: sale[%d][%d][%d]= %d %n", k+1,i,j,k,sale[i][j][k] );
				}
				System.out.println("---------------------------------------------");
			}
			System.out.println();
		}
	}
}
