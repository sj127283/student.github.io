package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_bo.add_bo;
import student_dao.student_dao;
/**
 * Servlet implementation class edit_handler
 */
@WebServlet("/edit_handler")
public class edit_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 response.setContentType("text/html");
			
			PrintWriter pw=response.getWriter();
			
			   String id=request.getParameter("id");

			      add_bo eb= student_dao.getEmployeeById(id);
			    
				pw.print("<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Home-Student</title>\r\n"
						+ " <link rel=\"stylesheet\" href=\"CSS/home.css\">\r\n"
						+ "</head>\r\n"
						+ "<body >\r\n"
						+ "    <div id=\"mr\">\r\n"
						+ "        <marquee behavior=\"\" direction=\"\"><h3><i>Welcome to Student Management System</i></h3></marquee>\r\n"
						+ "    </div>\r\n"
						+ "\r\n"
						+ "<center>\r\n"
						+ "    <table>\r\n"
						+ "        <tr>\r\n"
						+ "            <td><a href=\"homepage.html\">HOME</a></td>\r\n"
						+ "            <td><a href=\"add.html\">ADD DATA</a></td>\r\n"
						+ "            <td><a href=\"all_emp_controller\">VIEW DATA</a></td>\r\n"
						+ "        </tr>\r\n"
						+ "    </table>\r\n"
						+ "</center>   \r\n"
						+ "</body>\r\n"
						+ "</html>"); 
				
				pw.print("<center><br><br><form  action='update_handler' method='get' style='background-color:white;  width: 500px;  height: 400px;'> ");
			    
				pw.print("<table>");
				pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
				pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
			   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
			   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
			   	pw.print("<tr><td>Date of Joining : </td> <td><input type='text' name='doj' value='"+eb.getDoj()+"'/></td></tr>");
			   	pw.print("<tr><td>Date of Birth: </td> <td><input type='text' name='dob' value='"+eb.getEoj()+"'/></td></tr>");
			   	pw.print("<tr><td>Adhar Card: </td> <td><input type='text' name='adhar' value='"+eb.getAdhar()+"'/></td></tr>");   
			   	pw.print("</table>");
				
			   	pw.print("<input type='submit' value='Update' align='center' style='color:white; background-color: green;' />");
				pw.print("</form></center>");
			
	}

}
