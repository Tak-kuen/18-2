package Game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class MainFrame extends JFrame implements ActionListener,MouseListener, Runnable {

	private JLabel titleLabel = new JLabel();			//게임타이틀표시용라벨
	private JLabel timeLabel = new JLabel();			//시간표시용라벨
	private JLabel nextNumLabel = new JLabel();			//다음 뭐눌러야할지 보여주는 라벨
	private JButton startBtn = new JButton("START");	//게임시작버튼
	private JButton scoreBtn = new JButton("SCORE");
	private JButton rankBtn = new JButton("RANK");
	private JMenuBar mb = new MenuBar();
	JMenu screenMenu = new JMenu("Screen");
	JMenuItem refresh = new JMenuItem("Refresh");
	JMenuItem exit = new JMenuItem("Exit");
	
	Container con;
	
	SimpleDateFormat timeFormat;						//시간값을변환하기위한포맷
	String showTime, fasterTime;						//진행시간값을받아들일문자열
	long startTime, currentTime, actualTime;			//게임시작시간, 컴퓨터시간, 실제게임진행시간
	boolean timeRun = false;
	Thread thread;
	ImagePanel gameNum;
	HighScore hs;
	Rank rk;
	String id;
	boolean finished=false;
	boolean already=false;
	
	public MainFrame(String id) {//생성자
		this.id=id;
		init();
		start();
		
		setTitle("1 to 50 Game");
		setSize(600, 650);
		mb.add(screenMenu);
		screenMenu.add(refresh);
		screenMenu.addSeparator();
		screenMenu.add(exit);
		refresh.addActionListener(this);
		exit.addActionListener(this);
		this.setJMenuBar(mb);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - getHeight() / 2);
		setLocation(xpos, ypos);
		setResizable(false);
		setVisible(true);
	}

	public void init() {
		//게임라벨, 버튼및게임화면용패널설정
		
		con = this.getContentPane();
		con.setLayout(null);
		
		
		nextNumLabel.setBounds(100,50, 150, 30);
		nextNumLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		con.add(nextNumLabel);
		
		titleLabel.setBounds(250, 10, 300, 30);
		titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		con.add(titleLabel);
		
		timeLabel.setBounds(400, 50, 150, 30);
		timeLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		con.add(timeLabel);
		//프레임에표시할텍스트라벨
		
		
		startBtn.setBounds(100, 520, 100, 30);
		startBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		con.add(startBtn);
		
		scoreBtn.setBounds(250, 520, 100, 30);
		scoreBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		con.add(scoreBtn);
		
		rankBtn.setBounds(400, 520, 100, 30);
		rankBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		con.add(rankBtn);
		//프레임에표시할게임시작및리셋버튼
		
		gameNum = new ImagePanel();
		gameNum.setBounds(100, 100, 410, 410);
		con.add(gameNum);
		//게임화면용패널
	}

	public void start() {	//프레임내실행시킬기본내용
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		//프레임내마우스동작활성화
		startBtn.addMouseListener(this);
		scoreBtn.addMouseListener(this);
		rankBtn.addMouseListener(this);
		nextNumLabel.setText("다음 숫자 : " + gameNum.nextNum);
		thread = new Thread(this);
		thread.start();
		timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
		timeLabel.setText("00:00:00.000");
		titleLabel.setText("1 to 50 Game");
		gameNum.gameStart(false);
	}
	public void run() {
		while (true) {
			try {
				repaint();
				TimeCheck();
				Thread.sleep(15);
				nextNumLabel.setText("다음 숫자 : " + gameNum.nextNum);
			} catch (Exception e) {
			}
		}
	}

	public void TimeCheck() {
		if (timeRun) {
			currentTime = System.currentTimeMillis();
			actualTime = currentTime - startTime;
			gameNum.countDown((int) actualTime / 1000);
			
			if (!gameNum.game_start && gameNum.check <= 50) {
				//게임세팅완료후게임시작되면게임진행시간갱신
				showTime = timeFormat.format(actualTime - 32403000);
				timeLabel.setText(showTime);
			}
		}
		if ( gameNum.check > 50){
			fasterTime=timeLabel.getText();
			gameNum.ClearTime(fasterTime);
			finished=true;
			//insertDB(fasterTime);
			
			//숫자50까지클릭이끝나면게임클리어메세지띄울준비
		}
	}
	public void scoreInsert() {
		if(finished==true && already==false) {
			GameDBBean bean = GameDBBean.getInstance();
			System.out.println(bean.insertScore(fasterTime,id));
			already=true;
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == startBtn) {
			//게임시작버튼
			if (!timeRun && !gameNum.game_start ) {
				startTime = System.currentTimeMillis();
				gameNum.rect_select.clear();
				timeRun = true;
				gameNum.gameStart(true);
			}
		}else if (e.getSource() == scoreBtn) {
			scoreInsert();
			hs = new HighScore(id);
		}else if (e.getSource() ==rankBtn) {
			scoreInsert();
			rk= new Rank(id);
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
			case("Refresh"):
				this.setVisible(false);
				this.dispose();
				MainFrame mf = new MainFrame(id);
				break;
			case("Exit"):
				System.exit(0);
				break;
		}
	}
}
