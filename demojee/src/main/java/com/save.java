package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class save
 */
public class save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String Name=	request.getParameter("Name");
		String age=	request.getParameter("age");
		String Standard=	request.getParameter("Standard");
		String Subject=	request.getParameter("Subject");
		String Subject_id=	request.getParameter("Subject_id");
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
			stmt.setString(1, id);
			stmt.setString(2, Name);
			stmt.setString(3, age);
			stmt.setString(4, Standard);
			stmt.setString(5, Subject);
			stmt.setString(6, Subject_id);
			
			stmt.execute();
			
			stmt.close();
			
			stmt.close();
			
			
			out.println("<font color = 'Blue' >Student Saved!!!</font>");
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
		doGet(request, response);
	}

}
