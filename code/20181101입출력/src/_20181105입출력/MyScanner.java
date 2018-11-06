package _20181105입출력;

import java.io.*;
import java.util.*;

class MyScanner {
	public void print() {
		Scanner scan =null;
		BufferedReader br;
		FileReader rf;
		try {
			//문자단위 입력 클래스
			rf = new FileReader("D:\\1501163\\code\\20181101입출력\\src\\_20181105입출력\\input.txt");
			//버퍼를 이용한 클래스
			br = new BufferedReader(rf);
			//Scanner 객체 생성
			scan = new Scanner(br);
			
			boolean isFirst = true;
			int index = 0;
			int sum=0;
			//읽어오면서 토큰단위로 추출
			while(scan.hasNext()) {
				if(scan.hasNextInt()) {
					if(isFirst) {
						System.out.print(scan.next());
						isFirst=false;
						index=0; sum=0;
					} else {
						sum= sum + scan.nextInt();
						index++;
						if(index==3) {
							System.out.println(sum + "\t평균 :" + sum/3.0);
							isFirst=true;
						}
					}
				}else {
					System.out.print(" "+scan.next() + " ");
					
				}
			}
			if(scan !=null) {
				scan.close();
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}