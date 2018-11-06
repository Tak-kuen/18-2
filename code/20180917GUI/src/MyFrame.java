import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

class MyFrame extends JFrame{
	
	public MyFrame() {
		this.setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("title");
		//프레임의 아이콘을 변경한다.
		Toolkit kit =Toolkit.getDefaultToolkit();
		Image img = kit.getImage("images.png");
		setIconImage(img);
		//배치관리자 실행
		this.setLayout(new FlowLayout());
		//컨테이너에 컴퍼넌트를 추가
		//1.버튼 컴퍼넌트를 생성
		JButton button = new JButton("버튼");
		//2.컨테이너에 추가
		this.add(button);
		
		
		
		
		
		
		setVisible(true);
	}
}