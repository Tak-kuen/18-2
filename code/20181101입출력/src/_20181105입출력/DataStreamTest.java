package _20181105입출력;

import java.io.*;
import java.util.Date;

class  WDB {
	public void write() {
		//바이너리 파일을 생성해 데이터를 저장
		//기초 자료형 단위로 데이터 저장하기 위한 클래스
		DataOutputStream dos = null;
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("D:\\1501163\\code\\20181101�����\\src\\_20181105�����\\test.bin");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			//파일에 정수값을 저장
			dos.writeInt(100);
			//파일에 실수값을 저장
			dos.writeDouble(3.141592);
			//파일에 문자열을 저장
			dos.writeUTF("F*ck");
			//실제 파일에 저장
			dos.flush();
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void read() {
		//바이너리 파일을 생성해 데이터를 저장
		//기초 자료형 단위로 데이터 저장하기 위한 클래스
		DataInputStream dis = null;
				
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\1501163\\code\\20181101입출력\\src\\_20181105입출력\\test.bin");
			BufferedInputStream bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			//파일로부터 정수값을 읽어옴
			int a = dis.readInt();
			double b= dis.readDouble();
			String c = dis.readUTF();
			System.out.printf("정수값 : %d 실수값 : %f 문자열 : %s",a,b,c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void serial() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos =null;
		
		Date a = new Date();
		System.out.println(a);
		try {
			oos=new ObjectOutputStream( new FileOutputStream("D:\\object.dat"));
			oos.writeObject(a);
			oos.flush();
			oos.close();
			
			Thread.sleep(10000);
			ois = new ObjectInputStream(new FileInputStream("D:\\object.dat"));
			
			Date b = (Date)ois.readObject();
			System.out.println(b);
		} catch (IOException | InterruptedException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

public class DataStreamTest{
	public static void main(String[] args) {
		WDB test = new WDB();
//		test.write();
//		test.read();
		test.serial();
	}
}