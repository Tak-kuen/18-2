package _0918LinearList;
//1501163��Ź��
public class Ex5_3 {
	public static void main(String[] args) {
		int sale[][][]= new int[][][] {{{63,84,140,130},{157,209,251,312}}
		,{{59,80,130,135},{149,187,239,310}}};
		
		for(int i=0; i<sale.length;i++) {
			System.out.printf("<< %d�� >> %n", i+1);
			for(int j=0; j<sale[0].length;j++) {
				for(int k=0;k<sale[0][0].length;k++) {
					System.out.printf("%d/4�б� : sale[%d][%d][%d]= %d %n", k+1,i,j,k,sale[i][j][k] );
				}
				System.out.println("---------------------------------------------");
			}
			System.out.println();
		}
	}
}
