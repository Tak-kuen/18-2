package �̺�Ʈ181008;

import java.util.TimerTask;

class TrafficTask extends TimerTask {

	TrafficPanel tPanel;
	
	public TrafficTask(TrafficPanel tPanel) {
		// TODO Auto-generated constructor stub
		this.tPanel = tPanel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		tPanel.count++;
		tPanel.repaint();

	}

}
