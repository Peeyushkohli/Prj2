package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlignEdit
 */



//@WebServlet (urlPatterns= {"/AlignEdit"})
public class AlignEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AlignEdit() {
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
			
			String Tid=request.getParameter("tid");
			out.println("IDis " + Tid);
		
			//Integer fid =Integer.parseInt(Tid);
			//String TName=request.getParameter("tName");
			//String Tage=request.getParameter("tage");
			//String TStandard=request.getParameter("tStandard");
			String TSubject=request.getParameter("tSubject");
			String  TSubject_id=request.getParameter("tSubject_id");
			
			pst=con.prepareStatement("update student set Subject=?,Subject_id=? where id=?");
			
			//pst=con.prepareStatement("update student set Subject='"+tSubject+"',Subject_id="+tSubject_id+"? where id=Tid");
			//pst.setString(1, TName);
			
			//pst.setString(2, Tage);
			//pst.setString(3, TStandard);
			pst.setString(1, TSubject);
			pst.setString(2, TSubject_id);
			pst.setString (3, Tid);
			
			pst.executeUpdate();
			//pst.executeLargeUpdate(Tid);
			
			
			
			response.sendRedirect("viewstudent");
			out.println("<font color = 'Blue' >Student Aligned </font>");
			
					
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}
	}
	

