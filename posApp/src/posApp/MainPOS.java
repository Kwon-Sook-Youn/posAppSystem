package posApp;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainPOS extends JFrame{
	
	public POS_pos pos = null;
	public POS_StockManagement stockManagement = null;

	public static void main(String[] args) {

		MainPOS mainPOS = new MainPOS();
		mainPOS.setTitle("POS System");
		
		mainPOS.pos = new POS_pos();
		mainPOS.stockManagement = new POS_StockManagement();
		
		JTabbedPane jtab = new JTabbedPane();
		jtab.add("POS", mainPOS.pos);
		jtab.add("������", mainPOS.stockManagement);
		
		mainPOS.add(jtab);
		mainPOS.setSize(550, 400);
		mainPOS.setVisible(true);

	}

}
