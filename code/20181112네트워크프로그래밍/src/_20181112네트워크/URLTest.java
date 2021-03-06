package _20181112네트워크;

import java.io.*;
import java.net.*;

public class URLTest {
	public static void main(String[] args) {
		URL naver=null;
		URLConnection naverC=null;
		
		try {
			naver = new URL("https://www.yju.ac.kr/kr/index.do");
			naverC = naver.openConnection();
			
			InputStream is = naverC.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String inLine;
			
			while((inLine=br.readLine())!=null) {
				System.out.println(inLine);
			}
			br.close();
				
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
