package �׷���181001;
import javax.swing.*;



class MyFrame extends JFrame {
	public MyFrame() {
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���󺯰� �̺�Ʈ");
		setVisible(true);
		JPanel panel = new MyPanel();
		add(panel);
	}
}

public class WDB {
	
	public static void main(String[] args) {
		MyFrame myFrame= new MyFrame();
	}

}
