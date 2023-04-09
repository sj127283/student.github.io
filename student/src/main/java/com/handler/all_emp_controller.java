package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_bo.add_bo;
import student_dao.student_dao;
/**
 * Servlet implementation class all_emp_controller
 */
@WebServlet("/all_emp_controller")
public class all_emp_controller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public all_emp_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		response.setContentType("text/html");
		PrintWriter  pw=response.getWriter();
		
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
		pw.print("<br><br>");
		
		pw.print(" <center><a href='homepage.html'>Back</a>");
		pw.print("<br><br>");
		
        pw.print("<table border='1px solid black'  width='1000px' style='background-color: rgb(235, 191, 198);' >  ");
	    
	    pw.print("<tr> <th>ID </th><th> Name </th> <th> Email </th> <th> Phone </th> <th> Date Of Joining </th> <th>Birth Date </th> <th> Aadhaar</th>  <th> Delete</th><th>Update</th></tr>");
		
	    List<add_bo> list= student_dao.get_all_employee();
		   
		  for(add_bo eb:list) 
		  {
			  
			   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getDoj()+"</td><td>"+eb.getEoj()+"</td><td>"+eb.getAdhar()+"</td><td><a href='delete_handler?id="+eb.getId()+"'>Delete </a> </td><td><a href='edit_handler?id="+eb.getId()+"'>Edit </a> </td></tr>"); 
		  }
		   
		  pw.print("</table></center>");
		  
	}

}
