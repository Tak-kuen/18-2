package 이벤트181004;

import java.awt.Color;
import 이벤트181004.MyFrame1_402;
import java.awt.event.*;

import javax.swing.*;

// 독립적인 클래스로 이벤트를 구현할때 프레임의 속성을 변경하고싶다면
// 이벤트 추가할때 매개변수로 패널이나 버튼의 정보를 넘겨주어야 한다.

public class MyListener1 implements ActionListener {
	JPanel myPanel = null;
	JButton myButton = null;
	public MyListener1(JPanel myPanel) {
		this.myPanel = myPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn.getText().equals("노란색")) {
			myPanel.setBackground(Color.YELLOW);
		} else if (btn.getText().equals("분홍색")) {
			myPanel.setBackground(Color.PINK);
			
		}
		
	}

}