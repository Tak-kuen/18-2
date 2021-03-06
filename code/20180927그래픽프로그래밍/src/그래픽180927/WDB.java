package 그래픽180927;
import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.PINK);
		g.fillOval(200, 100, 200, 200);	//중심좌표 300,200
		g.setColor(Color.BLACK);
		g.drawLine(300,300,300,450);
		g.drawLine(300, 450, 220, 530);
		g.drawLine(300, 450, 380, 530);
		g.drawLine(300,320, 220, 400);
		g.drawLine(300,320, 380, 400);
		g.drawArc(275, 225, 50, 50, 225, 90);
		g.fillOval(244, 144, 12, 12);
		g.fillOval(344, 144, 12, 12);
		g.drawString("1501163 송탁근", 260, 550);
		g.setColor(Color.RED);
		g.fillOval(250, 170, 100, 60);
		g.setColor(Color.WHITE);
		g.fillOval(270,192, 16, 16);
		g.fillOval(310,192, 16, 16);
		
	}
}


class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("그래픽테스트");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//Panel을 생성하여 추가한다.
		MyPanel myPanel = new MyPanel();
		add(myPanel);
	}
}

public class WDB {
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
	}
	
}