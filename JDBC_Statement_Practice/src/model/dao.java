package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Controller.UserBean;

final public class dao {
	
	
	Connection conn = DbConnection.getConnection();//to get connection
	
	
	// this is used for insert in database
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
			
			
			//For Connection close
			return num;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	//this is used for get all users from database
	public ResultSet selectUser() {
		Statement st;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM form");
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs; 
	}
	
	
	//this is used for get particular user according to id
	public ResultSet selectbyId(int uid) {
		Statement st;
		ResultSet rs = null;
		int user_id = uid;
		
			try {
				st = conn.createStatement();
				rs = st.executeQuery("SELECT * FROM form WHERE id =" + user_id);
				
				return rs;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
	}
	
	
	//this function is used for make string from string array in checkbox logic
	public String makeString(String[] A) {
		
		 String str[] = A;
		 String sum = "";
		 for(int i = 0 ; i<str.length ; i++) {
			
			 if (i == str.length - 1) {
				sum += str[i];
			} else {
				sum += str[i] + ",";
			}
			 
		 }
		
		return sum;
	}
	
	
	//this is used to rum update data logic
	public int update(UserBean ub) {
		int count = 0;
		Statement st;
		try {
			st = conn.createStatement();
			count = st.executeUpdate("UPDATE form SET Fname='"+ub.getFname()+"',Lname='"+ub.getLname()+"',Age='"+ub.getAge()+"',Phone='"+ub.getPhone()+"',Email='"+ub.getEmail()+"',Birthdate='"+ub.getBirthdate()+"',Gender='"+ub.getGender()+"',Hobbie='"+ub.getHobbie()+"',Language='"+ub.getLanguang()+"' WHERE id='"+ub.getId()+"'");
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	//this logic is used to rum delete user or data 
	public int delete(UserBean ub) {
		int count = 0;
		Statement st;
		
		try {
			st = conn.createStatement();
			count = st.executeUpdate("DELETE FROM form WHERE id ="+ub.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return count;
	}
	
	
}
	