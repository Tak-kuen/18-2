package Game;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	public MenuBar() {
		JMenu screenMenu = new JMenu("Screen");
		JMenuItem refresh = new JMenuItem("Refresh");
		JMenuItem exit = new JMenuItem("Exit");
	}
}
