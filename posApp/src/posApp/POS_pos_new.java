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

public class POS_pos_new extends JPanel implements ActionListener{
	
	//ItemDAO ��ü ����(dao) �� �ε�
	
	//"��ǰ �ҷ�����" ��ư ��ü ����(btnDB)
	//"��ǰ" �� ��ü ����(lblItem)
	//"��ǰ����Ʈ" �޺��ڽ� ��ü ����(cmbBox)
	//"����" �� ��ü ����(lblStock)
	//"�����Է¹ڽ�" �ؽ�Ʈ�ʵ� ��ü ����(txtStock)
	//"�Ѱ���" �� ��ü ����(lblTotal)
	//"�Ѱ��� ��¹ڽ�" �ؽ�Ʈ�ʵ� ��ü ����(txtTotal)
	//"�߰�" ��ư ��ü ����(btnAdd)
	//"����" ��ư ��ü ����(btnPay)
	//"���" ��ư ��ü ����(btnCancel)
	//"���̺����" JTable ��ü ����(jTableItem)
	
	//JTable�� ����� Model ��ü ����(tableModel)
	//JComboBox�� ����� Model ��ü ����(comboModel)
	
	//�Ѱ��� ������ ������ ������� ����(total)
	
	public POS_pos_new() {
		
		//�ڵ� ��ġ ���̾ƿ� ��Ȱ��ȭ
		setLayout(null);
		
		//�� ������Ʈ ��ü ���� �� ȭ�� ��ġ/ũ�� ����
		//btnDB = new JButton("��ǰ �ҷ�����");
		//btnDB.setBounds(20, 20, 140, 40);
		
		
		//JPanel�� �߰�
		//add(btnDB);
		
		//�̺�Ʈ ó���� ���� ������ ���
		//btnDB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//�̺�Ʈ ��ü�κ��� �ؽ�Ʈ ��������
		//��ǰ��, ���, ���� ������ �������� ���� �� �ʱ�ȭ
		
		//[��ǰ �ҷ�����] ��ư Ŭ�� ��
		if() {
			//comboBox�� ��� ������ ��� ����(removeAllItems());
			
			//DB�κ��� ��ǰ�� ��ü �˻� �� Vector�� ����
			//Vector�� ������ ��ǰ���� comboBox�� �߰�
			
		}//[�߰�] ��ư Ŭ�� ��
		else if() {
			// comboBox���� ������ ��ǰ��� �ؽ�Ʈ�ʵ忡 �Է��� ���� ����
			// DB�κ��� ����ڰ� ������ ��ǰ���� �ܰ� �ҷ�����
			// ����ڰ� ������ ��ǰ�� ���Ű���(�ܰ�*����)�� ���� �Ѿ� �����ϱ�
			// ��ǰ��, ���ż���, ���Ű���, �����Ѿ��� Vector�� ����
			// Vector ��ü�� tableModel�� �߰�
			
		}//[����] ��ư Ŭ�� ��
		else if() {
			// "�����Ͻðڽ��ϱ�?"��� ���̾�α� â ���(JOptionPane.showConfirmDialog())
			// "YES"�� ������ "�ѱݾ��� ~�Դϴ�"�� ����� �� ����ڷκ��� ���� �Է¹ޱ�(JOptionPane.showInputDialog())
			// ����� �Է±ݾ��� �ѱݾ׺��� ũ�� "���ұݾ�,�Ž�����"�� ����� �� DB ������Ʈ(stockUpdate), ��� ������Ʈ ���� ������ �ʱ�ȭ(clean())    
			// �׷��� ������ "�ݾ��� �����ϴ�" Dialog â ���
			
		}//[���] ��ư Ŭ�� ��
		else {
			// "�ֹ��� ����Ͻðڽ��ϱ�?" Dialog â ���
			// ��� ������Ʈ�� ������ �ʱ�ȭ
		}
	}
	
	// JTable, ������ �Ѱ����� JTextField �� ������ �ʱ�ȭ
	public void clean() {
		
	}
	
	// JTable�� ��µ� ��� �������� ��ǰ��, ���, ������ �̿��Ͽ� DB ������ ������Ʈ 
	public void stockUpdate(DefaultTableModel model) {
					
		}		
	}
}
