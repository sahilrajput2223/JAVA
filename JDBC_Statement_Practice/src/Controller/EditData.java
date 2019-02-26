package Controller;

import model.dao; 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			ServletContext sc = request.getServletContext();
			int id = Integer.parseInt(sc.getAttribute("idForSubmitData").toString());
			
			dao d = new dao();
			
			//to get form data
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			int age = Integer.parseInt(request.getParameter("age"));
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String birthdate = request.getParameter("birthdate");
			String gender = request.getParameter("gender");
			String hobbie[] = request.getParameterValues("hobbie");
			String language[] = request.getParameterValues("language");
			
			
			
			String hobbies = d.makeString(hobbie);
			String languages = d.makeString(language);
			
			PrintWriter pf = response.getWriter();
			
			
			UserBean ub = new UserBean();
			
			ub.setId(id);
			ub.setFname(fname);
			ub.setLname(lname);
			ub.setAge(age);
			ub.setPhone(phone);
			ub.setEmail(email);
			ub.setBirthdate(birthdate);
			ub.setGender(gender);
			ub.setHobbie(hobbies);
			ub.setLanguang(languages);
			
			 
			int num = d.update(ub);
			
			if (num > 0 ) {
				pf.println("Data Updated Done");
			} else {
				pf.println("Data Not Updated");
			}
		}


	}


