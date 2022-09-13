package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlignEditTeacher
 */
//@WebServlet("/AlignEditTeacher")
public class AlignEditTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlignEditTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		Connection con;
		PreparedStatement pst;
		//ResultSet rs;
		int row;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
			
			String Tid=request.getParameter("Teacher_id");
			out.println("IDis " + Tid);
		
			//Integer fid =Integer.parseInt(Tid);
			//String TName=request.getParameter("Teacher_name");
			//String Tage=request.getParameter("Teacher_age");
			
			//String TStandard=request.getParameter("DOB ");
			//String TSubject=request.getParameter("DOJ ");
			String TS=request.getParameter("Teches_subject");
			String  TSub_id=request.getParameter("Sub_id");
			
			pst=con.prepareStatement("update teacher set Teches_subject=?,Sub_id=? where Teacher_id=?");
			//pst=con.prepareStatement("update teacher set Teches_subject='"+TS+"',Sub_id="+TSub_id+" where Teacher_id="+Tid);
			//pst.setString(1, Teacher_name);
			
			//pst.setString(2, Teacher_age);
			//pst.setString(3, DOB );
			//pst.setString(1, DOJ );
			pst.setString(1, TS);
			pst.setString(2, TSub_id);
			pst.setString (3, Tid);
			
			pst.executeUpdate();
			//pst.executeLargeUpdate(Tid);
			
			
			
			response.sendRedirect("viewteacher");
			out.println("<font color = 'Blue' >Teacher Aligned </font>");
			
					
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

}
