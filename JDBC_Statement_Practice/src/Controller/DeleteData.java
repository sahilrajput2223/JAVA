package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao;

@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("getIdFromTableToDelete"));
		
		PrintWriter pw = response.getWriter() ;
		dao d = new dao();
		UserBean ub = new UserBean();

		ub.setId(id);
		int i = d.delete(ub);
		
		if(i > 0) {
			response.sendRedirect("table.jsp");
		}
		else {
			pw.println("Data Not Deleted");
		}
	}

}
