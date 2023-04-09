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
 * Servlet implementation class update_handler
 */
@WebServlet("/update_handler")
public class update_handler extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_handler()
    {
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
         
        String name= request.getParameter("name");
        String email= request.getParameter("email");
        String phone= request.getParameter("phone");
        String doj= request.getParameter("doj");
        String dob= request.getParameter("dob");
        String adhar= request.getParameter("adhar");
        
        
        add_bo eb=new add_bo();
        eb.setId(id);;
        eb.setName(name);
        eb.setEmail(email);
        eb.setPhone(phone);
        eb.setDoj(doj);
        eb.setEoj(dob);
        eb.setAdhar(adhar);
        
       int status= student_dao.Update(eb);
       
       if(status>0) {
     	   
     	  RequestDispatcher rd=request.getRequestDispatcher("all_emp_controller");
     	    rd.forward(request, response);
     	    
       }

      

	}

}
