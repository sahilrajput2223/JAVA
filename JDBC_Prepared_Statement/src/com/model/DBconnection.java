package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class DBconnection {
	
	static Connection connection = null;
	
	
	public static Connection getDataBaseConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_jdbc_prepared_statement" , "root" , "" ); 
			return connection;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	public static void CloseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
