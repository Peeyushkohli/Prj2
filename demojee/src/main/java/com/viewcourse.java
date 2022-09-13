package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewcourse
 */
public class viewcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResultSet rs;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewcourse() {
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
			sql="select * from subject ";
			Statement stmt =con.createStatement();
			rs=stmt.executeQuery(sql);
									
			
			
		//stmt.close();
			out.println("<table cellspacing='0' width='350px' border='1'>");
			out.println("<tr>");
			out.println("<td> Subject_id </td>");
			out.println("<td> Subject</td>");
			out.println("<td> Tought in Standard</td>");
		    out.println("<td> Aligned </td>");
			
			out.println("</tr>");
			while(rs.next())
			{
				
				
				
				out.println("<tr>");
				
				
				out.println("<td >" + rs.getString("Subject_id") + "</td >");
				out.println("<td >" + rs.getString("Subject") +"</td >");
				out.println("<td > "+ rs.getString("toght_in_standard") + "</td >");
						
			
				//out.println("<td > " + "<a href ='Align?id=" +rs.getString("id") + "'> ALIGN</a>" + "</td >");
				//out.println("<td > " + "<a href ='Del?id=" +rs.getString("id") +" > DELETE</a>" + "</td >");
				out.println("</tr>");
				
				
			}
				out.println("</table>"); 
		}
				 catch (Exception e)
		 {
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
