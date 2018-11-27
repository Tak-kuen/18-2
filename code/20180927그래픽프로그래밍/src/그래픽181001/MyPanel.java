package 그래픽181001;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
//이벤트 넣기
//1. 리스너 인터페이스를 상속
//2. 버튼에 리스너 등록
//3. 리스너 이벤트 처리 메소드 구현
import java.io.IOException;
	
class MyPanel extends JPanel implements ActionListener {	//1번과정
	
		private	JButton button;
		private Color color = new Color(0,0,0);
		BufferedImage img=null;
		
		public MyPanel() {
			setLayout(new BorderLayout());
			button = new JButton("색상변경");
			button.addActionListener(this);					//2번과정
			//addActionListener()에서 괄호안에 이벤트 처리할 객체가 있는곳을 알려줌
			add(button, BorderLayout.SOUTH);
			try {
				img = ImageIO.read(new File("D:\\1501163\\code\\20180927그래픽프로그래밍\\src\\dd.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(color);
			g.fillRect(10, 10, 50, 50);
			
			Font f1=new Font("Serif", Font.PLAIN,20);
			g.setFont(f1);
			g.drawString("Serif 20 PLAIN", 10, 100);
			Font f2=new Font("San Serif", Font.BOLD,20);
			g.setFont(f2);
			g.drawString("San Serif 20 BOLD", 10, 120);
			Font f3=new Font("한컴 백제 M", Font.ITALIC,20);
			g.setFont(f3);
			g.drawString("한컴 백제 M 20 ITALIC", 10, 140);
			Font f4=new Font("D2coding", Font.BOLD,20);
			g.setFont(f4);
			g.drawString("D2coding 20 BOLD", 10, 160);
			g.drawImage(img,0,0,null);
		}

		public void actionPerformed(ActionEvent e) {		//3번과정
			color = new Color((int)(Math.random()*255.0),
					(int)(Math.random()*255.0),(int)(Math.random()*255.0));
			repaint();
		}
		
		
		
	}