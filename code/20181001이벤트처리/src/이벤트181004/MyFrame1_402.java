package 이벤트181004;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame1_402 extends JFrame {
	private JButton buttonYellow;
	private JButton buttonPink;
	private JPanel panel;
	
	public MyFrame1_402() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("액션이벤트예제");
		panel=new JPanel();
		buttonYellow=new JButton("노란색");
		buttonPink = new JButton("분홍색");
		buttonYellow.addActionListener(new MyListener1(panel));
		buttonPink.addActionListener(new MyListener1(panel));
		
		panel.add(buttonYellow);
		panel.add(buttonPink);
		
		//키보드 눌렀을때 이벤트
		panel.addKeyListener(new MyKeyListener(panel));
		panel.setFocusable(true);							
		this.add(panel);
		this.setVisible(true);
		
		
		
	}

}