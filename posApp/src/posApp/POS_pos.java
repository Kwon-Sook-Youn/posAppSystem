package posApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class POS_pos extends JPanel implements ActionListener{
	
	ItemDAO dao = ItemDAO.getInstance();
	
	JButton btnDB;
	
	JLabel labelItemName;
	JComboBox comboBox;
	
	JLabel labelItemStock;
	JTextField txtStock;
	
	JLabel labelItemTotal;
	JTextField txtTotal;
	
	JButton btnAdd;
	JButton btnPay;
	JButton btnCancel;
	
	JTable jStock;
	
	DefaultTableModel tableModel; 
	DefaultComboBoxModel comboModel;
	
	int total = 0;
	
	public POS_pos() {
		
		setLayout(null);
		
		btnDB = new JButton("��ǰ �ҷ�����");
		btnDB.setBounds(20, 20, 140, 40);
		
		labelItemName = new JLabel("��ǰ");
		labelItemName.setBounds(20, 90, 100, 30);
		
		comboModel = new DefaultComboBoxModel();
		comboBox = new JComboBox(comboModel);
		comboBox.setBounds(70, 90, 200, 30);
		
		labelItemStock = new JLabel("����");
		labelItemStock.setBounds(20, 140, 100, 30);
		
		txtStock = new JTextField(10);
		txtStock.setBounds(70, 140, 200, 30);
		
		labelItemTotal = new JLabel("�Ѱ���");
		labelItemTotal.setBounds(20, 250, 100, 40);
		
		txtTotal = new JTextField(10);
		txtTotal.setBounds(70, 250, 200, 40);
		txtTotal.setEditable(false);
		
		btnAdd = new JButton("�߰�");
		btnAdd.setBounds(170, 190, 100, 40);
		
		btnPay = new JButton("����");
		btnPay.setBounds(300,250,100,40);
		
		btnCancel = new JButton("���");
		btnCancel.setBounds(410, 250, 100, 40);
		
		tableModel = new DefaultTableModel();		
		tableModel.addColumn("��ǰ��");
		tableModel.addColumn("���ŷ�");
		tableModel.addColumn("�ܰ�");
		tableModel.addColumn("�Ѿ�");
		JTable jStock = new JTable(tableModel);		
		jStock.setBounds(300, 20, 210, 210);
		jStock.setEnabled(false);
		
		add(btnDB);
		add(labelItemName);
		add(comboBox);
		add(labelItemStock);
		add(txtStock);
		add(labelItemTotal);
		add(txtTotal);
		add(btnAdd);
		add(btnPay);
		add(btnCancel);
		add(jStock);
		
		btnDB.addActionListener(this);
		btnAdd.addActionListener(this);
		btnPay.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		String menu = e.getActionCommand();
		int stock = 0;
		String itemName = "";
		int price = 0;
		
		//[��ǰ �ҷ�����] ��ư Ŭ�� ��
		if(menu=="��ǰ �ҷ�����") {
			comboBox.removeAllItems();			
			Vector<String> itemlist = new Vector<String>();
			try {
				itemlist = dao.getItem();
				Iterator it = itemlist.iterator();
				while(it.hasNext()) {
					comboBox.addItem(it.next());
				}				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(menu=="�߰�") {
			stock = Integer.parseInt(txtStock.getText());
			itemName = (String)comboBox.getSelectedItem();
			try {
				price = Integer.parseInt(dao.getPrice(itemName));
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int sum = stock * price;
			total = total + sum;
			txtTotal.setText(String.valueOf(total));
			
			Vector<String> in = new Vector<String>();
			in.add(itemName);
			in.add(String.valueOf(stock));
			in.add(String.valueOf(price));
			in.add(String.valueOf(sum));
			tableModel.addRow(in);			
		}else if(menu=="����") {
			int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?");
			if(result==0) {
				int input = Integer.parseInt(JOptionPane.showInputDialog("�� �ݾ��� " + txtTotal.getText() +"�Դϴ�"));
				if(input > Integer.parseInt(txtTotal.getText())) {
					JOptionPane.showMessageDialog(null, "�����Ͻ� �ݾ��� " + input+"�̰� " + "\n��ǰ�� �հ�� " + txtTotal.getText()+"�̸�, \n�Ž������� " + (input-Integer.parseInt(txtTotal.getText())) + "�Դϴ�");
					stockUpdate(tableModel);
					clean();					
				}else {
					JOptionPane.showMessageDialog(null, "�ݾ��� �����մϴ�.\n���縦 ����մϴ�");
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "�ֹ��� ����Ͻðڽ��ϱ�?");
			clean();
		}
	}
	
	public void clean() {
		int rows = tableModel.getRowCount();
		for(int i=rows-1; i>=0; i--)
			tableModel.removeRow(i);
		txtTotal.setText("");
		txtStock.setText("");
	}
	
	public void stockUpdate(DefaultTableModel model) {
		for(int i=0; i<model.getRowCount(); i++) {
			String name = (String)model.getValueAt(i, 0);
			String stock = (String)model.getValueAt(i, 1);
			String price = (String)model.getValueAt(i, 2);
			
			String total = dao.getStock(name);
			
			int tot = Integer.parseInt(total);
						
			System.out.println("name = " + name);
			System.out.println("total = " + tot);
			System.out.println("stock = " + stock);
			System.out.println("remain = " + (tot-Integer.parseInt(stock)));
			
			try {
				dao.updateStock(total, stock, name);				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
}
