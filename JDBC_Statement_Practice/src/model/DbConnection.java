package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class DbConnection {
	static Connection conn;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_jdbc_statement" , "root" , "" ); 
			 //This is for make connection
			 //here java_jdbc_statement is DATABASE name AND root is username and NULL is password for phpmyadmin 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
			//This is for return connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
