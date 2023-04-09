package com.handler;


import java.io.IOException;
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
 * Servlet implementation class signup_handler
 */
@WebServlet("/signup_handler")
public class signup_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter  pw=response.getWriter();
		
	String user_name=request.getParameter("user_name");
	int pass=Integer.parseInt(request.getParameter("pass"));
	int con_pass=Integer.parseInt(request.getParameter("pass_confirm"));
	String name=request.getParameter("name");
	String date=request.getParameter("dob");
	String city=request.getParameter("city");
	String course=request.getParameter("course");
	
	login_bo lb=new login_bo();
	
	lb.setUser_name(user_name);
	lb.setPassword(pass);
	lb.setConfirm_pass(con_pass);
	lb.setName(name);
	lb.setDob(date);
	lb.setCity(city);
	lb.setCourse(course);
	
	int status=student_dao.signup(lb);

	if(status>0)
	{	
	    pw.print("sign up sucessfull");
	  
	  RequestDispatcher rp=request.getRequestDispatcher("login.html");
	
		rp.forward(request, response);
		
		
	}
	else 
	{
		 pw.print("something went wrong  please try again<br>");
		  
		  RequestDispatcher rp=request.getRequestDispatcher("signup.html");
		
			rp.include(request, response);
	}
	
 }
	
	
	
}
