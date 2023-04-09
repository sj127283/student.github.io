package com.handler;

import java.io.IOException
;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_bo.login_bo;
import student_dao.student_dao;

/**
 * Servlet implementation class login_handler
 */
@WebServlet("/login_handler")
public class login_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_handler() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter  pw=response.getWriter();
		
		String user_name=request.getParameter("user");
		int pass=Integer.parseInt(request.getParameter("pass"));
		
		
		if(student_dao.user_login(user_name, pass))
		{
			pw.print("login sucessfull");
			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.html");
			
			rd.forward(request, response);
		}
		else
		{
			
            pw.print("User ID or Password Wrong!!!");
			
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			
			rd.include(request, response);
		}
		
	}

}
