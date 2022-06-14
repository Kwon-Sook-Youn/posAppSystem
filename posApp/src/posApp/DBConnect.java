package posApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	public static final String dbUrl = "jdbc:mysql://localhost:3306/pos?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
	public static final String dbUser = "root";
	public static final String dbPwd = "1234";
	public static Connection conn = null;

	public static Connection connect() {
		
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			//if(conn!=null)
				//System.out.println("Connection succeed!");
			//else
				//System.out.println("Connection failed!");			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver load error!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB connection failed!");
		}
		return conn;
	}
	
	public static void close(Connection con) {
			try {
				if(con!=null) {
					//System.out.println("Connection closed!");
					con.close();					
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//System.out.println("Connection Closing failed!");
				System.out.println(e.getMessage());
			}
	}
}
