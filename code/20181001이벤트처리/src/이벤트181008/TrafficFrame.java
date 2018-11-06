package 이벤트181008;


import javax.swing.*;

class TrafficFrame extends JFrame{
	TrafficFrame() {
		this.setSize(300,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Test");
		JPanel tPanel = new TrafficPanel();
		add(tPanel);
		this.setVisible(true);
	}
}
