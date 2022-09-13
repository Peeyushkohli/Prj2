package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.taglibs.standard.tag.el.core.OutTag;

import java.sql.*;
/**
 * Servlet implementation class viewstudent
 */
//@WebServlet("/viewstudent")
public class viewstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			
		PrintWriter out=response.getWriter();
			
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
				String sql;
				sql="select * from student ";
				Statement stmt =con.createStatement();
				rs=stmt.executeQuery(sql);
										
				
				
			//stmt.close();
				out.println("<table cellspacing='0' width='370px' border='2'>");
				out.println("<tr>");
				out.println("<td> Student Id </td>");
				out.println("<td> Name </td>");
				out.println("<td> Age</td>");
			    out.println("<td> Standard</td>");
				out.println("<td> Subject </td>");
				out.println("<td> Subject Code </td>");
				out.println("<td> Align </td>");
				out.println("<td> Delete </td>");
				
				out.println("</tr>");
				while(rs.next())
				{
					
									
					out.println("<tr>");
					
					
					out.println("<td >" + rs.getString("id") + "</td >");
					out.println("<td >" + rs.getString("Name") +"</td >");
					out.println("<td > "+ rs.getString("age") + "</td >");
					out.println("<td >" + rs.getString("Standard") + "</td >");
					out.println("<td >" + rs.getString("Subject") + "</td >");
					out.println("<td > "+ rs.getString("Subject_id") +"</td >");
					
					out.println("<td > " + "<a href ='Align?id=" +rs.getString("id") + "'> ALIGN/EDIT </a>" + "</td >");
					out.println("<td > " + "<a href ='DelStu?id=" +rs.getString("id") +"' > DELETE</a>" + "</td >");
					out.println("</tr>");
				    
					
				}
				
				out.println("</table>");
			} catch (Exception e) {
				System.out.println(e);
			}
			out.println("<p><a href = 'MainPortal.jsp' >Home</a></p>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
