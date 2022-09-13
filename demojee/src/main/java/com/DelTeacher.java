package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelTeacher
 */
public class DelTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		
		//String tempid=request.getParameter("u");
		
		
		//int id =Integer.parseInt(tempid);
		String Tid=request.getParameter("Teacher_id");
		//Integer  tid =Integer.parseInt(Tid);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
			
			pst=con.prepareStatement("delete from teacher  where  Teacher_id=?");
			pst.setString(1, Tid);
			Statement stmt =con.createStatement();
			pst.executeUpdate();
									
					
			response.sendRedirect("viewteacher");
			out.println("<font color = 'Blue' >Teacher Deleted </font>");
			
			
		
			
			
			
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
