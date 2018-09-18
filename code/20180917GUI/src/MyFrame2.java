import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

class MyFrame2 extends JFrame {
	public MyFrame2() {
		setSize(600,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("title");
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(5,2));
		for(int i=0 ; i<10;i++) {
			String name= i +""+ i;
			panel.add(new JButton(name));
		}
		
		
		this.add(panel);
		setVisible(true);
	}
}