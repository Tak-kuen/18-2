package 이벤트181008;

import javax.swing.*;

class MyFrameS extends JFrame {
	
	MyFrameS() {
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트예제");
		JPanel myPanel = new MyPanelS();
		add(myPanel);
		this.setVisible(true);
	}
}
