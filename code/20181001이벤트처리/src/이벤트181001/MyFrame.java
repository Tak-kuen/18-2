package 이벤트181001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
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
		button.addActionListener(this);
//		button.addActionListener(new MyListener());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button1=(JButton)e.getSource();
//		if (i%2==0) {
//			button1.setText("버튼 누름");
//			i++;
//		} else {
//			button1.setText("버튼을 눌렀음");
//			i++;
//		}
//		if(button1.getText().equals("버튼을 누르세요")||button1.getText().equals("버튼을 눌렀음")) {
//			button1.setText("버튼 누름");
//		} else if(button1.getText().equals("버튼 누름")) {
//			button1.setText("버튼을 눌렀음");
//		}
		if(button1.getText().equals("버튼 누름")) {
			button1.setText("버튼을 누르세요");
		} else {
			button1.setText("버튼 누름");
		}
		
		
		
	}
	
}