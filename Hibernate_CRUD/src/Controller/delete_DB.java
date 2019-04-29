package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Student;
import model.Dao;

@WebServlet("/delete_DB")
public class delete_DB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int sid = Integer.parseInt(request.getParameter("id"));
	Student s = new Student();
	s.setSid(sid);
	Dao d = new Dao();
	d.delete(s);
	response.sendRedirect("Display.jsp");
	}

}
