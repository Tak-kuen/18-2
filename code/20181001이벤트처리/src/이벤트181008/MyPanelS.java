package 이벤트181008;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class MyPanelS extends JPanel {
	BufferedImage img=null;
	int x,y;
	
	public MyPanelS() {
		x=100; y=100;
		try {
			img = ImageIO.read(new File("D:/1501163/code/20181001이벤트처리/src/이벤트181008/icon.png"));
		} catch (IOException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
		//리스너 등록
		this.addKeyListener(new MyKeyListener(this));
		this.setFocusable(true);
		this.requestFocus();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,x,y,null);
	}
}