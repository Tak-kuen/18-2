package _20181105입출력;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile2 {
	public static void main(String[] args) {
		//파일로부터 문자 단위를 데이터를 읽어오는 작업을 하는 클래스
		FileReader fi;
				
		//파일로부터 문자 단위를 데이터를 저장하는 작업을 하는 클래스
		FileWriter fo;
		
		try {
			//파일을 읽기위한 객체를 생성
			fi=new FileReader("D:\\1501163\\code\\20181101�����\\src\\_20181105�����\\input.txt");
					
			//파일에 쓰기위한 객체를 생성
			fo= new FileWriter("D:\\1501163\\code\\20181101�����\\src\\_20181105�����\\output.txt");
					
			//한 문자 단위로 읽어서 저장하는 반복구조
			int b;
			//read()의 값이 -1일때 파일의 끝
			while((b=fi.read()) != -1) {
				fo.write(b);
				System.out.print(b +"\t");
				System.out.println((char)b +"\t");
			}
			if (fi!=null) {
				fi.close();
			}
			if (fo!=null) {
				fo.close();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}
}
