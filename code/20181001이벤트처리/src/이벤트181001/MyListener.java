package ¿Ã∫•∆Æ181001;

import java.awt.event.*;

import javax.swing.JButton;
class MyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button1=(JButton)e.getSource();
		button1.setText((int)(Math.random()*100) + "");
		
	}
	

}
