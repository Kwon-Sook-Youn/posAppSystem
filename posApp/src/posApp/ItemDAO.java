package posApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ItemDAO {
	
	private ItemDAO() {
	}
	
	private static ItemDAO instance = new ItemDAO();
	
	public static ItemDAO getInstance() {
		return instance;
	}
	
	public Vector<Item> getAllItem() throws Exception{
		Vector<Item> list = new Vector<Item>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String price = null;
		String sql = "select * from item";
		
		try {
			conn = DBConnect.connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_stock(rs.getInt("item_stock"));
				item.setItem_price(rs.getInt("item_price"));
				list.add(item);
			}
		}catch(SQLException e) {
			System.out.println("SQL Error!");
		}finally {
			rs.close();			
			pstmt.close();
			DBConnect.close(conn);
		}
		
		return list; 
	}
	
	public Vector<String> getItem() throws SQLException{
		Vector<Item> dblist = new Vector<Item>();
		Vector<String> itemlist = new Vector<String>();
		try {
			dblist = getAllItem();
			
			for(Item item: dblist) {
				itemlist.add(item.getItem_name());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  itemlist;
	}
	
	public String getPrice(String item_name) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String price = null;
		String sql = "select item_price from item where item_name=?";
		
		try {
			conn = DBConnect.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				price = Integer.toString(rs.getInt("item_price"));
			}
		}catch(Exception e) {
			System.out.println("SQL Error!");
		}finally {
			rs.close();
			pstmt.close();
			DBConnect.close(conn);
		}
		
		return price;
	}
	
	public String getStock(String item_name) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String stock = null;
		String sql = "select item_stock from item where item_name=?";
		
		try {
			conn = DBConnect.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				stock = Integer.toString(rs.getInt("item_stock"));
			}
		}catch(Exception e) {
			System.out.println("SQL Error!");
		}
		
		return stock;
	}
	
public void updateStock(String total, String stock, String item_name) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update item set item_stock=?-? where item_name=?";
		
		try {
			conn = DBConnect.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, total);
			pstmt.setString(2, stock);
			pstmt.setString(3, item_name);
			pstmt.executeUpdate();			
			
		}catch(Exception e) {
			System.out.println("SQL Error!");
		}finally {
			pstmt.close();
			DBConnect.close(conn);
		}
	}

public boolean insertStock(Item item) throws SQLException {	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "insert into item(item_name, item_stock, item_price) values(?,?,?)";
	int r=0;
	boolean result = false;
	try {
		conn = DBConnect.connect();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, item.getItem_name());
		pstmt.setInt(2, item.getItem_stock());
		pstmt.setInt(3, item.getItem_price());
		r = pstmt.executeUpdate();
		if(r>0)
			result = true;
		System.out.println("return result = " + r);
	}catch(Exception e) {
		System.out.println("SQL Error!");
	}finally {
		pstmt.close();
		DBConnect.close(conn);
	}
	return result;
}

public boolean updateItem(Item item) throws SQLException {	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "update item set item_name=?, item_stock=?, item_price=? where id=?";
	boolean result=false;
	try {
		conn = DBConnect.connect();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, item.getItem_name());
		pstmt.setString(2, Integer.toString(item.getItem_stock()));
		pstmt.setString(3, Integer.toString(item.getItem_price()));
		pstmt.setInt(4, item.getId());
		pstmt.executeUpdate();
		result = true;
	}catch(Exception e) {
		System.out.println("SQL Error!");
	}finally {
		pstmt.close();
		DBConnect.close(conn);
	}
	return result;
}

public boolean deleteItem(int id) throws SQLException {	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "delete from item where id=?";
	boolean result=false;
	try {
		conn = DBConnect.connect();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		result = true;
	}catch(Exception e) {
		System.out.println("SQL Error!");
	}finally {
		pstmt.close();
		DBConnect.close(conn);
	}
	return result;
}

}
