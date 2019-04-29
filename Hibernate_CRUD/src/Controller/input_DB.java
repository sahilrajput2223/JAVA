package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Student;
import model.Dao;

@WebServlet("/input_DB")
public class input_DB extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
	
		Student s = new Student();
		s.setUsername(username);
		s.setEmail(email);
		s.setPhone(phone);
		
		Dao d = new Dao();
		d.insert(s);
	
		response.sendRedirect("Display.jsp");
	}

}
