package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Dao;

@WebServlet("/update_db")
public class update_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private java.sql.Date convertToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime()); 
		return sDate;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ServletContext context = request.getServletContext();
		int userID = Integer.parseInt(context.getAttribute("user_ID").toString());
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int age = Integer.parseInt(request.getParameter("age"));
		long phone = Long.parseLong(request.getParameter("phone"));
		String email = request.getParameter("email");
		String birthdate = request.getParameter("birthdate");
		String gender = request.getParameter("gender");
		String hobbie[] = request.getParameterValues("hobbie");
		String language[] = request.getParameterValues("language");
		
		
		Dao d = new Dao();
		
		String hobbies = d.makeString(hobbie);
		String languages = d.makeString(language);
		
		
		try {
			
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date bdate;
			bdate = sdf.parse(birthdate);
			java.sql.Date  Bdate = convertToSql(bdate);
			
		
			UserBean ub = new UserBean();
			
			ub.setUser_id(userID);
			ub.setFname(fname);
			ub.setLname(lname);
			ub.setAge(age);
			ub.setPhone(phone);
			ub.setEmail(email);
			ub.setBirthdate(Bdate);
			ub.setGender(gender);
			ub.setHobbies(hobbies);
			ub.setLanguages(languages);
			
			
			int count = d.update(ub);
			
			if(count > 0) {
				System.out.print("Data Updated");
				response.sendRedirect("DisplayData.jsp");
			}
			else {
				System.out.println("Data not Updated");
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
