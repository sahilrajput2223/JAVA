package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Dao;

@WebServlet("/delete_db")
public class delete_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			PrintWriter pw = response.getWriter(); 
			int user_ID = Integer.parseInt(request.getParameter("userID"));
			
			Dao d = new Dao();
			int count = d.delete(user_ID);
			
			if( count > 0 ) {
				response.sendRedirect("DisplayData.jsp");
			}
			else {
				pw.println("Data Not Deleted .... ");
			}
	}

}
