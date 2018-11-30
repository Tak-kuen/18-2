package Game;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;

public class HighScore extends JFrame{
	JPanel score;
	JLabel scorenum;
	String userid;
	ArrayList<ScoreBean> scoreList = new ArrayList<>();
	boolean scored = false;
	
	HighScore(String id) {
		this.userid=id;
		score = new JPanel();
		score.setLayout(new GridLayout(0,2));
		score.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
//		score.add(scorenum);
		GameDBBean db = GameDBBean.getInstance();
		scoreList=db.idScore(userid);
		if(scored==false) {
			for(ScoreBean bean:scoreList) {
				score.add(new JLabel(bean.getTime()));
				score.add(new JLabel(bean.getUserid()));
				scored=true;
			}
		}
		
		
		
		
		this.add(score);
		this.setTitle("HighScore");
		this.setSize(400,100);
		this.setVisible(true);
		
		
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int y = (int) (screen.getHeight() / 2 - getHeight() / 2);
		setLocation(x, y);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
			}
		});
	}
}
