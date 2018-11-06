package 이벤트181004;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

class MyKeyListener implements KeyListener {
	JPanel myPanel = null;
	MyKeyListener(JPanel myPanel) {
		this.myPanel = myPanel;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		char ch = e.getKeyChar();
		if (ch=='r')
			myPanel.setBackground(Color.RED);
		else if(ch=='g')
			myPanel.setBackground(Color.GREEN);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char ch = e.getKeyChar();
		if (ch=='r')
			myPanel.setBackground(Color.WHITE);
		else if(ch=='g')
			myPanel.setBackground(Color.WHITE);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		

	}

}
