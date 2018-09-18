package _0918LinearList;
//1501163 º€≈π±Ÿ
public class Ex5_2 {
	public static void main(String[] args) {
		int sale[][] = new int[][] {{63,84,140,130},{157,209,251,312}};
		
		for(int i=0 ; i<sale.length ; i++) {
			for(int j=0; j<sale[0].length;j++) {
				System.out.printf("%d/4∫–±‚ : sale[%d][%d]= %d %n", j+1,i,j,sale[i][j]);	
			}
			System.out.println();
		}
	}
}
