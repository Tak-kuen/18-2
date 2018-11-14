package _20181108입출력;

import java.io.*;

public class WDB {
	public static void main(String[] args) {
		String name="C:\\windows";
		
		File file = new File(name);
		//디렉토리인지 검사
		if(file.isDirectory()) {
			System.out.println(name + " 디렉토리입니다.");
			String[] list =file.list();
			for(String s:list) {
				File f = new File(name+ "\\" +s);
				System.out.println("---------------------------");
				System.out.println("이름 : " +  f.getName());
				System.out.println("경로 : " +  f.getPath());
				System.out.println("부모 : " +  f.getParent());
				System.out.println("디렉토리 여부 : " +  f.isDirectory());
				System.out.println("파일 여부 : " +  f.isFile());
			}//for
		}else {
			System.out.println(name + "파일입니다.");
		}//if-else
	}
}
