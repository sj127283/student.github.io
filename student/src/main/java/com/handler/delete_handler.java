package com.handler;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_dao.student_dao;
/**
 * Servlet implementation class delete_handler
 */
@WebServlet("/delete_handler")
public class delete_handler extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_handler() {
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
		
		 student_dao.delete(id);
		 
		response.sendRedirect("all_emp_controller");
	}

}
