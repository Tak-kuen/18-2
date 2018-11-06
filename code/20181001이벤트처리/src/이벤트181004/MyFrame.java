package 이벤트181004;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame {
	private JButton button;
	int i=0;
	
	MyFrame() {
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("버튼이벤트 예제");
		this.setLayout(new FlowLayout());
		button=new JButton("버튼을 누르세요");
		this.add(button);
		this.setVisible(true);
//---------------- 무명클래스로 이벤트 구현
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button1=(JButton)e.getSource();
				button1.setText((int)(Math.random()*100) + "");
			}
		});
	}
//---------------- 내부클래스로 이벤트 구현
//	class MyListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton button1=(JButton)e.getSource();
//			button1.setText((int)(Math.random()*100) + "");
//			
//		}
//	}//MyListener				
}//MyFrame