package ¿Ã∫•∆Æ181008;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

class MyKeyListener implements KeyListener {
	private MyPanelS myPanel;
	private int offset=10;
	
	MyKeyListener(MyPanelS panel) {
		this.myPanel = panel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_RIGHT :
			myPanel.x = myPanel.x + offset;
			break;
		case KeyEvent.VK_DOWN:
			myPanel.y = myPanel.y + offset;
			break;
		case KeyEvent.VK_UP:
			myPanel.y = myPanel.y - offset;
			break;
		case KeyEvent.VK_LEFT:
			myPanel.x = myPanel.x - offset;
			break;
		}
		myPanel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
