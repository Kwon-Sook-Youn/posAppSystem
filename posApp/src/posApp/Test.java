package posApp;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Test {

	public static void main(String[] args) throws Exception{
		
		ItemDAO dao = ItemDAO.getInstance();
		Vector<Item> list = new Vector<Item>(); 
		
		System.out.println("*** DB 연결 및 해제 ***");
		/*
		list = dao.getAllItem();
		
		Iterator it = list.iterator();
		
		System.out.println("*** 전체 검색 ***");
		while(it.hasNext()) {
			Item item = (Item)it.next();
			System.out.println(item.getId()+", " + item.getItem_name() + ", " + item.getItem_stock()+", " + item.getItem_price());
		}
		
		System.out.println("*** 제품명 검색 ***");
		Vector<String> itemlist = new Vector<String>();
		itemlist = dao.getItem();
		it = itemlist.iterator();
		while(it.hasNext()) {
			String itemName = (String)it.next();
			System.out.println(itemName);
		}
		
		System.out.println("*** 제품단가 검색 ***");
		String price = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("제품명 : ");
		String input = sc.next();
		price = dao.getPrice(input);
		System.out.println(input+"의 단가는"+ price);
		
		System.out.println("*** 재고수량 검색 ***");
		String stock = null;
		System.out.println("제품명 : ");
		input = sc.next();
		price = dao.getStock(input);
		String price2 = price;
		System.out.println(input+"의 재고수량은"+ price);
		
		System.out.println("*** 재고수량 수정 ***");
		stock = null;
		System.out.println("제품명 : ");
		input = sc.next();
		System.out.println("구매수량 : ");
		String count = sc.next();
		dao.updateStock(price2, count, input);
		System.out.println(input+"의 재고수량은"+ dao.getStock(input));

		System.out.println("*** 상품 등록 ***");
		String stock = null;
		System.out.println("제품명 : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("수량 : ");
		int c = sc.nextInt();
		System.out.println("단가 : ");
		int item_p = sc.nextInt();
		Item item = new Item();
		item.setItem_name(name);
		item.setItem_stock(c);
		item.setItem_price(item_p);
		dao.insertStock(item);
		
		list = dao.getAllItem();
		
		Iterator it = list.iterator();
		
		System.out.println("*** 전체 검색 ***");
		while(it.hasNext()) {
			item = (Item)it.next();
			System.out.println(item.getId()+", " + item.getItem_name() + ", " + item.getItem_stock()+", " + item.getItem_price());
		}

		
		System.out.println("*** 상품 수정 ***");
		Scanner sc = new Scanner(System.in);
		Item item = new Item();
		System.out.println("상품명 : ");
		String name = sc.next();
		System.out.println("수량 : ");
		int c = sc.nextInt();
		System.out.println("가격 : ");
		int price = sc.nextInt();
		item.setItem_name(name);
		item.setItem_stock(c);
		item.setItem_price(price);
		item.setId(6);
		dao.updateStock(item);
		
		list = dao.getAllItem();
		
		Iterator it = list.iterator();
		
		System.out.println("*** 전체 검색 ***");
		while(it.hasNext()) {
			item = (Item)it.next();
			System.out.println(item.getId()+", " + item.getItem_name() + ", " + item.getItem_stock()+", " + item.getItem_price());
		}
						*/
		System.out.println("*** 상품 삭제 ***");
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 번호 : ");
		int number = sc.nextInt();
		dao.deleteItem(number);
		
		list = dao.getAllItem();
		
		Iterator it = list.iterator();
		
		System.out.println("*** 전체 검색 ***");
		while(it.hasNext()) {
			Item item = (Item)it.next();
			System.out.println(item.getId()+", " + item.getItem_name() + ", " + item.getItem_stock()+", " + item.getItem_price());
		}
		
	}
}
