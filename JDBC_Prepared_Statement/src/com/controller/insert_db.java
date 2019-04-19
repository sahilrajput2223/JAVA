package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Dao;

@WebServlet("/insert_db")
public class insert_db extends HttpServlet {
	private static final long serialVersionUID = 1L;

		private Date convertToSql(java.util.Date uDate) {
			java.sql.Date sDate = new java.sql.Date(uDate.getTime()); 
			return sDate;
		}
	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		String fname = request.getParameter("fname");
    		String lname = request.getParameter("lname");
    		int age = Integer.parseInt(request.getParameter("age"));
    		long phone =Long.parseLong(request.getParameter("phone"));
    		String email = request.getParameter("email");
    		String birthdate = request.getParameter("birthdate");
    		String gender = request.getParameter("gender");
    		String hobbie[] = request.getParameterValues("hobbie");
    		String language[] = request.getParameterValues("language");
    		
    		
    		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
    		java.util.Date bdate;
    		
    		try {
				bdate = sdf.parse(birthdate);
				java.sql.Date  Bdate = convertToSql(bdate);
				Dao d = new Dao();
	    		String hobbies = d.makeString(hobbie);
	    		String languages = d.makeString(language);
	    		
	    		UserBean ub = new UserBean();
	    		
	    		
	    		ub.setFname(fname);
	    		ub.setLname(lname);
	    		ub.setAge(age);
	    		ub.setPhone(phone);
	    		ub.setEmail(email);
	    		ub.setBirthdate(Bdate);
	    		ub.setGender(gender);
	    		ub.setHobbies(hobbies);
	    		ub.setLanguages(languages);
	    		
	    		int num = d.insert(ub);
	    		
	    		if(num > 0){
	    			System.out.println("Data Insert Done");
	    			response.sendRedirect("DisplayData.jsp");
	    		}
	    		else {
	    			System.out.println("Data not inserted");
	    		}
	    		
    		} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		
    		
    		
    		
    }

}
