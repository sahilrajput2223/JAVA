package model;

import java.sql.Connection;

import java.sql.Statement;

import Controller.UserBean;

final public class dao {
	
	
	Connection conn = DbConnection.getConnection();
	//to get connection
	public int insert(UserBean ub)
	{
		int num ;
		Statement st;
		try {
			String fname = ub.getFname();
			String lname = ub.getLname();
			int age = ub.getAge();
			String phone = ub.getPhone();
			String email = ub.getEmail();
			String birthdate = ub.getBirthdate();
			String gender = ub.getGender();
			String hobbie = ub.getHobbie();
			String language = ub.getLanguang();
			
			st = conn.createStatement();
			num = st.executeUpdate("INSERT INTO form(Fname,Lname,Age, Phone, Email,Birthdate,Gender, Hobbie, Language) VALUES ('"+fname+"','"+lname+"',"+age+","+phone+",'"+email+"','"+birthdate+"','"+gender+"','"+hobbie+"','"+language+"')");
			
			DbConnection.closeConnection();
			//For Connection close
			return num;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
	
	
	public String makeString(String[] A) {
		
		 String str[] = A;
		 String sum = "";
		 for(int i = 0 ; i<str.length ; i++) {
			 sum += str[i] + ",";
		 }
		
		return sum;
	}
}
