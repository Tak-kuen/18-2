import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

class MyFrame extends JFrame{
	
	public MyFrame() {
		this.setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("title");
		//�������� �������� �����Ѵ�.
		Toolkit kit =Toolkit.getDefaultToolkit();
		Image img = kit.getImage("images.png");
		setIconImage(img);
		//��ġ������ ����
		this.setLayout(new FlowLayout());
		//�����̳ʿ� ���۳�Ʈ�� �߰�
		//1.��ư ���۳�Ʈ�� ����
		JButton button = new JButton("��ư");
		//2.�����̳ʿ� �߰�
		this.add(button);
		
		
		
		
		
		
		setVisible(true);
	}
}