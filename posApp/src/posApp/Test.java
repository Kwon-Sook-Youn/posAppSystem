package posApp;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Test {

	public static void main(String[] args) throws Exception{
		
		ItemDAO dao = ItemDAO.getInstance();
		Vector<Item> list = new Vector<Item>(); 
		
		System.out.println("*** DB ���� �� ���� ***");
		/*
		list = dao.getAllItem();
		
		Iterator it = list.iterator();
		
		System.out.println("*** ��ü �˻� ***");
		while(it.hasNext()) {
			Item item = (Item)it.next();
			System.out.println(item.getId()+", " + item.getItem_name() + ", " + item.getItem_stock()+", " + item.getItem_price());
		}
		
		System.out.println("*** ��ǰ�� �˻� ***");
		Vector<String> itemlist = new Vector<String>();
		itemlist = dao.getItem();
		it = itemlist.iterator();
		while(it.hasNext()) {
			String itemName = (String)it.next();
			System.out.println(itemName);
		}
		
		System.out.println("*** ��ǰ�ܰ� �˻� ***");
		String price = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰ�� : ");
		String input = sc.next();
		price = dao.getPrice(input);
		System.out.println(input+"�� �ܰ���"+ price);
		
		System.out.println("*** ������ �˻� ***");
		String stock = null;
		System.out.println("��ǰ�� : ");
		input = sc.next();
		price = dao.getStock(input);
		String price2 = price;
		System.out.println(input+"�� ��������"+ price);
		
		System.out.println("*** ������ ���� ***");
		stock = null;
		System.out.println("��ǰ�� : ");
		input = sc.next();
		System.out.println("���ż��� : ");
		String count = sc.next();
		dao.updateStock(price2, count, input);
		System.out.println(input+"�� ��������"+ dao.getStock(input));

		System.out.println("*** ��ǰ ��� ***");
		String stock = null;
		System.out.println("��ǰ�� : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("���� : ");
		int c = sc.nextInt();
		System.out.println("�ܰ� : ");
		int item_p = sc.nextInt();
		Item item = new Item();
		item.setItem_name(name);
		item.setItem_stock(c);
		item.setItem_price(item_p);
		dao.insertStock(item);
		
		list = dao.getAllItem();
		
		Iterator it = list.iterator();
		
		System.out.println("*** ��ü �˻� ***");
		while(it.hasNext()) {
			item = (Item)it.next();
			System.out.println(item.getId()+", " + item.getItem_name() + ", " + item.getItem_stock()+", " + item.getItem_price());
		}

		
		System.out.println("*** ��ǰ ���� ***");
		Scanner sc = new Scanner(System.in);
		Item item = new Item();
		System.out.println("��ǰ�� : ");
		String name = sc.next();
		System.out.println("���� : ");
		int c = sc.nextInt();
		System.out.println("���� : ");
		int price = sc.nextInt();
		item.setItem_name(name);
		item.setItem_stock(c);
		item.setItem_price(price);
		item.setId(6);
		dao.updateStock(item);
		
		list = dao.getAllItem();
		
		Iterator it = list.iterator();
		
		System.out.println("*** ��ü �˻� ***");
		while(it.hasNext()) {
			item = (Item)it.next();
			System.out.println(item.getId()+", " + item.getItem_name() + ", " + item.getItem_stock()+", " + item.getItem_price());
		}
						*/
		System.out.println("*** ��ǰ ���� ***");
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ��ȣ : ");
		int number = sc.nextInt();
		dao.deleteItem(number);
		
		list = dao.getAllItem();
		
		Iterator it = list.iterator();
		
		System.out.println("*** ��ü �˻� ***");
		while(it.hasNext()) {
			Item item = (Item)it.next();
			System.out.println(item.getId()+", " + item.getItem_name() + ", " + item.getItem_stock()+", " + item.getItem_price());
		}
		
	}
}
