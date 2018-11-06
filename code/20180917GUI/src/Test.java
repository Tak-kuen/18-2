import javax.swing.*;
import java.awt.*;

class Test extends JFrame {
	public Test() {
		setSize(600,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("title");
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JLabel id = new JLabel("학번");
		panel1.add(id);
		JTextField id_tf = new JTextField();
		id_tf.setText("1501163");
		panel1.add(id_tf);
		JLabel name = new JLabel("성명");
		panel1.add(name);
		JTextField name_tf = new JTextField();
		name_tf.setText("굿");
		panel1.add(name_tf);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,3));
		JLabel blank = new JLabel("");
		panel2.add(blank);
		JLabel ko = new JLabel("국어");
		panel2.add(ko);
		JLabel en = new JLabel("영어");
		panel2.add(en);
		JLabel _1_1 = new JLabel("1-1학기");
		panel2.add(_1_1);
		JLabel _1_1ko = new JLabel("10");
		panel2.add(_1_1ko);
		JLabel _1_1en = new JLabel("15");
		panel2.add(_1_1en);
		JLabel _1_2 = new JLabel("1-2학기");
		panel2.add(_1_2);
		JLabel _1_2ko = new JLabel("20");
		panel2.add(_1_2ko);
		JLabel _1_2en = new JLabel("30");
		panel2.add(_1_2en);
		JLabel _2_1 = new JLabel("2-1학기");
		panel2.add(_2_1);
		JLabel _2_1ko = new JLabel("10");
		panel2.add(_2_1ko);
		JLabel _2_1en = new JLabel("40");
		panel2.add(_2_1en);
		
		JPanel panel3= new JPanel();
		panel3.setLayout(new FlowLayout());
		JButton ok = new JButton("확인");
		panel3.add(ok);
		JButton cancel = new JButton("취소");
		panel3.add(cancel);
		
		JPanel con = new JPanel();
		con.setLayout(new BorderLayout(3,1));
		
		con.add(panel1,BorderLayout.NORTH);
		con.add(panel2,BorderLayout.CENTER);
		con.add(panel3,BorderLayout.SOUTH);
		this.add(con);
		setVisible(true);
	}
}
