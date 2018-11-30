package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFrame extends JFrame implements ActionListener{
	
	PreparedStatement pstmt;
	ResultSet rs;
	Connection conn=null;
	
	JTextField idf;
	JButton loginBtn;
	
	BufferedImage img;
	
	public LoginFrame() {
		setSize(450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		
		try {
			img = ImageIO.read(new File("D:\\game.jpeg"));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		JPanel loginPanel = new JPanel();
		
		idf= new JTextField(10);
		loginPanel.add(idf);
		
		loginBtn = new JButton("login");
		loginBtn.addActionListener(this);
		loginPanel.add(loginBtn);
		this.add(loginPanel);
		loginPanel.setBounds(120, 200, 200, 100);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - getHeight() / 2);
		setLocation(xpos, ypos);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GameDBBean bean = GameDBBean.getInstance();
		int result=bean.checkDB(idf.getText());
		if(result==1) {
			this.setVisible(false);
			this.dispose();
			new MainFrame(idf.getText());
		}else if(result==0) {
			this.idf.setText("");
		}
	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		System.out.println("?");
		super.paintComponents(g);
		g.drawImage(img,0,0,null);
		repaint();
	}

	

}
