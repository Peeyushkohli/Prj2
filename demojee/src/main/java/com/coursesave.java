package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class coursesave
 */
public class coursesave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coursesave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Subject_id=request.getParameter("Subject_id");
		String Subject=	request.getParameter("Subject");
		String  toght_in_standard =	request.getParameter("toght_in_standard");
	
		
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into  subject values(?,?,?)");
			stmt.setString(1, Subject_id);
			stmt.setString(2, Subject);
			stmt.setString(3, toght_in_standard);
			
			
			stmt.execute();
			
			stmt.close();
			response.setContentType("text/html");
			PrintWriter out =response.getWriter();
			
			out.println("<font color = 'Blue' >Course Saved!!!</font>");
			out.println("<p><a href = 'MainPortal.jsp' >Home</a></p>");
			





		} catch (Exception e) {
			System.out.println(e);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
		
	
	

	}

}
