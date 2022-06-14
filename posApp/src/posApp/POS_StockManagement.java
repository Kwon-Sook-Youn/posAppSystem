package posApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class POS_StockManagement extends JPanel implements ActionListener{

	JLabel labelName;
	JButton buttonDB;
	JButton buttonRegister;
	JButton buttonUpdate;
	JButton buttonDelete;
	static JTable jtableStock;
	
	public POS_StockManagement() {		
		
		setLayout(null);
		
		labelName = new JLabel("재고현황");
		labelName.setSize(100,40);
		labelName.setLocation(60, 20);
		
		buttonDB = new JButton("상품 새로고침");
		buttonDB.setBounds(10, 70, 150, 40);
		
		buttonRegister = new JButton("등록");
		buttonRegister.setBounds(10, 130, 150, 40);
		
		buttonUpdate = new JButton("수정");
		buttonUpdate.setBounds(10, 190, 150, 40);
		
		buttonDelete = new JButton("삭제");
		buttonDelete.setBounds(10, 250, 150, 40);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("상품명");
		dtm.addColumn("재고량");
		dtm.addColumn("단가");
		
		jtableStock = new JTable(dtm);
		JScrollPane jScollPane = new JScrollPane(jtableStock);
		jScollPane.setBounds(200, 20, 300, 280);
		
		add(labelName);
		add(buttonDB);
		add(buttonRegister);
		add(buttonUpdate);
		add(buttonDelete);
		add(jScollPane);
		
		buttonDB.addActionListener(this);
		buttonRegister.addActionListener(this);
		buttonUpdate.addActionListener(this);
		buttonDelete.addActionListener(this);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonTxt = e.getActionCommand();
		DefaultTableModel model = (DefaultTableModel)jtableStock.getModel();
		if(buttonTxt==buttonDB.getText()) {
			try {
				loadDB(model);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(buttonTxt==buttonRegister.getText()) {
			StockWindow window = new StockWindow(buttonTxt);
		}else if(buttonTxt==buttonUpdate.getText()) {
			int row = jtableStock.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "셀을 선택하세요!", "경고!", JOptionPane.WARNING_MESSAGE);				
			}else {
				String id = (String) jtableStock.getValueAt(row, 0);
				String name = (String) jtableStock.getValueAt(row, 1);
				String stock = (String) jtableStock.getValueAt(row, 2);
				String price = (String) jtableStock.getValueAt(row, 3);
				
				Item item = new Item();			
				item.setId(Integer.parseInt(id));
				item.setItem_name(name);
				item.setItem_stock(Integer.parseInt(stock));
				item.setItem_price(Integer.parseInt(price));
				StockWindow window = new StockWindow(buttonTxt, item);
			}
			
		}else if(buttonTxt==buttonDelete.getText()) {
			int row = jtableStock.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "셀을 선택하세요!", "경고!", JOptionPane.WARNING_MESSAGE);				
			}else {
				String id = (String) jtableStock.getValueAt(row, 0);
				String name = (String) jtableStock.getValueAt(row, 1);
				String stock = (String) jtableStock.getValueAt(row, 2);
				String price = (String) jtableStock.getValueAt(row, 3);
				
				Item item = new Item();			
				item.setId(Integer.parseInt(id));
				item.setItem_name(name);
				item.setItem_stock(Integer.parseInt(stock));
				item.setItem_price(Integer.parseInt(price));
				StockWindow window = new StockWindow(buttonTxt, item);				
			}
		}
		
	}
	
	public static void loadDB(DefaultTableModel model) throws Exception {
		
		int rows = model.getRowCount();
		
		for(int i=rows-1; i>=0; i--)
			model.removeRow(i);
		
		Vector<Item> itemlist = ItemDAO.getInstance().getAllItem();
		
		for(Item item: itemlist) {
			String item_id = String.valueOf(item.getId());
			String item_name = item.getItem_name();
			String item_stock = String.valueOf(item.getItem_stock());
			String item_price = String.valueOf(item.getItem_price());
			Vector<String> in = new Vector<String>();
			in.add(item_id);
			in.add(item_name);
			in.add(item_stock);
			in.add(item_price);
			model.addRow(in);
		}
	}	
}
