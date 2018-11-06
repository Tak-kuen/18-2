package 이벤트181008;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TrafficPanel extends JPanel {
	int count=0;
	JButton btn;
	JPanel trafficLight;
	
	public TrafficPanel() {
		
		this.setLayout(new BorderLayout());
		JButton btn = new JButton("색바꾸기");
		this.add(btn,BorderLayout.SOUTH);
		btn.addActionListener(new TrafficListener(this));
		this.setFocusable(true);
		this.requestFocus();
		
		//타이머 객체 생성
		Timer timer = new Timer();
		TrafficTask task = new TrafficTask(this);
		timer.schedule(task,1000,30);
		//					지연시간,반복시간(ms)
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 101, 101);
		g.drawOval(100, 200, 101, 101);
		g.drawOval(100, 300, 101, 101);
		
		if(count %3==0) {
			g.setColor(Color.RED);
			g.fillOval(100, 100, 100, 100);
		}else if(count%3==1) {
			g.setColor(Color.ORANGE);
			g.fillOval(100, 200, 100, 100);
		}else if(count%3==2) {
			g.setColor(Color.GREEN);
			g.fillOval(100, 300, 100, 100);
		}
		
	}
}
