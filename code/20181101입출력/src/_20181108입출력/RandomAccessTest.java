package _20181108입출력;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("D:\\random.bin","rw");
			raf.writeInt(10);
			raf.seek(4);
			raf.writeInt(2018001);
			raf.writeUTF("홍길동");
			raf.writeInt(20);
			raf.writeInt(20);
			raf.writeInt(20);
			raf.writeInt(2018002);
			raf.writeUTF("홍닐동");
			raf.writeInt(30);
			raf.writeInt(30);
			raf.writeInt(30);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
