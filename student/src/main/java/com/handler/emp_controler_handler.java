package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_bo.add_bo;
import student_dao.student_dao;

/**
 * Servlet implementation class emp_controler_handler
 */
@WebServlet("/emp_controler_handler")
public class emp_controler_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emp_controler_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter  pw=response.getWriter();
		
		String ID=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String doj=request.getParameter("doj");
		String date=request.getParameter("dob");
		String adhar=request.getParameter("adhar");

		add_bo ob=new add_bo(name,email,phone,doj,date,adhar,ID);
		
		int status=student_dao.add_emp(ob);
		
		
		if(status>0)
		{
             pw.print("Data inserted sucessfull");
			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.html");		
			rd.forward(request, response);
		}
		else
		{
			
            pw.print("Something went  Wrong!!!");
			
			RequestDispatcher rd=request.getRequestDispatcher("add.html");
			
			rd.include(request, response);
		}
		
		
		
	}

}
