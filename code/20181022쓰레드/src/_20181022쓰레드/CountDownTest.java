package _20181022쓰레드;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CountDownTest extends JFrame{
	private JLabel label; 
	
	class MyThread1 extends Thread{
		public void run() {
			for(int i=0; i<100;i++) {
				try {
					Thread.sleep(1000);
					label.setText(i +"");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public CountDownTest() {
		setTitle("카운트다운");
		setSize(600,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("시작");
		Font font=new Font("D2coding",Font.BOLD,100);
		label.setFont(font);
		add(label);
		
		MyThread1 myThread = new MyThread1();
		myThread.start();
		setVisible(true);
		
				
	}
}
