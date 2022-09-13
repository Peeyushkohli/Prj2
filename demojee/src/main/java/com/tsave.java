package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tsave
 */
public class tsave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tsave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Teacher_id=request.getParameter("Teacher_id");
		String Teacher_name=	request.getParameter("Teacher_name");
		String Teacher_age=	request.getParameter("Teacher_age");
		String DOB =	request.getParameter("DOB");
		String DOJ =	request.getParameter("DOJ");
		String Teches_subject=	request.getParameter("Teches_subject");
		String Sub_id=	request.getParameter("Sub_id");
		//String Subject=	request.getParameter("Subject");
		
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into teacher values(?,?,?,?,?,?,?)");
			stmt.setString(1, Teacher_id);
			stmt.setString(2, Teacher_name);
			stmt.setString(3, Teacher_age);
			stmt.setString(4, DOB);
			stmt.setString(5, DOJ);
			stmt.setString(6, Teches_subject);
			stmt.setString(7, Sub_id);
			//stmt.setString(8, Subject);
			
			stmt.execute();
			
			stmt.close();
			response.setContentType("text/html");
			PrintWriter out =response.getWriter();
			
			out.println("<font color = 'Blue' >Teacher Saved!!!</font>");
			out.println("<p><a href = 'MainPortal.jsp' >Home</a></p>");
			
		} catch (Exception e) {
			System.out.println(e);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}


	}



