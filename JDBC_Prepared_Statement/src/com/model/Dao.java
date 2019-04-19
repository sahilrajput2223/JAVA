package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.controller.UserBean;

public class Dao {
	
	
	// To genrate String
	public String makeString(String[] temp) {
		String[] A = temp;
		
		String B = "";
		int l = A.length;
		
		for(int i = 0 ; i < l ; i++) {
			
			if(i == (l-1)) {
				B += A[i];
			}else {
				B += A[i] + ",";
			}
		}
		
		return B;
	}
	
	
	
	//to insert into database
	public int insert(UserBean ub) {
		
		int row = 0;
		Connection conn = DBconnection.getDataBaseConnection();
		String str = "INSERT INTO register(fname, lname, age, phone, email, birthdate, gender, hobbies, languages) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(str);
			
			ps.setString(1,ub.getFname());
			ps.setString(2,ub.getLname());
			ps.setInt(3,ub.getAge());
			ps.setLong(4,ub.getPhone());
			ps.setString(5,ub.getEmail());
			ps.setDate(6,ub.getBirthdate());
			ps.setString(7,ub.getGender());
			ps.setString(8,ub.getHobbies());
			ps.setString(9,ub.getLanguages());
			
			
			row = ps.executeUpdate();
			
			DBconnection.CloseConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return row;
	}
	
	
	
	//for retrive all date
	public ResultSet select() {
		ResultSet resultSet = null;
		
		try {
			
			Connection conn = DBconnection.getDataBaseConnection();
			String str = "SELECT * FROM register";
			PreparedStatement ps = conn.prepareStatement(str);
			resultSet = ps.executeQuery();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	public int update(UserBean ub) {
		int count = 0;
		try {
			
			Connection conn = DBconnection.getDataBaseConnection();
			String query = "UPDATE register SET fname=?,lname=?,age=?,phone=?,email=?,birthdate=?,gender=?,hobbies=?,languages=? WHERE id =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ub.getFname());
			ps.setString(2, ub.getLname());
			ps.setInt(3, ub.getAge());
			ps.setLong(4, ub.getPhone());
			ps.setString(5, ub.getEmail());
			ps.setDate(6,ub.getBirthdate());
			ps.setString(7,ub.getGender());
			ps.setString(8, ub.getHobbies());
			ps.setString(9, ub.getLanguages());
			ps.setInt(10, ub.getUser_id());
			count = ps.executeUpdate(); 
			
			DBconnection.CloseConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	
	//for retrive particular data by id
	public ResultSet selectById(int Uid) {
	
		ResultSet resultSet = null;
		
		try {
			
			Connection conn = DBconnection.getDataBaseConnection();
			String str = "SELECT * FROM register WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setInt(1,Uid);
			resultSet = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	
	//for delete data from table
	public int delete(int userID) {
		int count = 0;
		try {
			Connection conn = DBconnection.getDataBaseConnection();
			String query = "DELETE FROM register WHERE id =?";
			PreparedStatement ps  = conn.prepareStatement(query);
			ps.setInt(1,userID);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}
