package posApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StockWindow extends JFrame implements ActionListener{

	JLabel labelId = new JLabel("ID");
	JLabel labelName = new JLabel("��ǰ��");
	JLabel labelStock = new JLabel("���");
	JLabel labelPrice = new JLabel("�ܰ�");
	
	JTextField txtFieldID = new JTextField(10);
	JTextField txtFieldName = new JTextField(10);
	JTextField txtFieldStock = new JTextField(10);
	JTextField txtFieldPrice = new JTextField(10);
	
	JButton buttonAccept = new JButton("");
	Item item;
	String menu;
	
	public StockWindow(String menu) {
		this.menu = menu;
		display();
		setSize(300,300);
		setVisible(true);
	}
	
	public StockWindow(String menu, Item item) {
		this.item = item;
		this.menu = menu;
		display();
		setSize(300,300);
		setVisible(true);
	}
	
	public void display() {
		Container ct = getContentPane();
		JPanel p = new JPanel(new GridLayout(4,2));	
		
		if(item!=null) {
			txtFieldID.setText(String.valueOf(item.getId()));
			txtFieldName.setText(item.getItem_name());
			txtFieldStock.setText(String.valueOf(item.getItem_stock()));
			txtFieldPrice.setText(String.valueOf(item.getItem_price()));			
		}
		
		p.add(labelId);
		p.add(txtFieldID);
		p.add(labelName);
		p.add(txtFieldName);
		p.add(labelStock);
		p.add(txtFieldStock);
		p.add(labelPrice);
		p.add(txtFieldPrice);
		buttonAccept.setText(menu);
		txtFieldID.setEditable(false);
		
		ct.add(p, BorderLayout.CENTER);
		ct.add(buttonAccept, BorderLayout.SOUTH);
		
		buttonAccept.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String menu = buttonAccept.getText();
		String id, name, stock, price;
		boolean result = false;
		
		switch(menu) {
			case "���":
				name = txtFieldName.getText();
				stock = txtFieldStock.getText();
				price = txtFieldPrice.getText();
				
				item = new Item();
				item.setItem_name(name);
				item.setItem_stock(Integer.parseInt(stock));
				item.setItem_price(Integer.parseInt(price));
				try {
					result = ItemDAO.getInstance().insertStock(item);
					DefaultTableModel model = (DefaultTableModel)POS_StockManagement.jtableStock.getModel();
					POS_StockManagement.loadDB(model);
					this.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "����":
				id = txtFieldID.getText();
				name = txtFieldName.getText();
				stock = txtFieldStock.getText();
				price = txtFieldPrice.getText();
				
				item = new Item();
				item.setId(Integer.parseInt(id));
				item.setItem_name(name);
				item.setItem_stock(Integer.parseInt(stock));
				item.setItem_price(Integer.parseInt(price));
				
				int answer = JOptionPane.showConfirmDialog(null, "���� �����Ͻðھ��?", "Confirm", JOptionPane.YES_NO_OPTION);				
				
				if(answer==JOptionPane.YES_OPTION) {
					try {						
						result = ItemDAO.getInstance().updateItem(item);						
						DefaultTableModel model = (DefaultTableModel)POS_StockManagement.jtableStock.getModel();
						POS_StockManagement.loadDB(model);
						this.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}				
				break;
				
			case "����":
				id = txtFieldID.getText();		
				
				answer = JOptionPane.showConfirmDialog(null, "���� �����Ͻðھ��?", "Confirm", JOptionPane.YES_NO_OPTION);				
				
				if(answer==JOptionPane.YES_OPTION) {
					try {						
						result = ItemDAO.getInstance().deleteItem(Integer.parseInt(id));						
						DefaultTableModel model = (DefaultTableModel)POS_StockManagement.jtableStock.getModel();
						POS_StockManagement.loadDB(model);
						this.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				break;				
		}
	}
}
