package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewteacher
 */

//@WebServlet("/viewteacher")
public class viewteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ResultSet rs;
    public viewteacher() {
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
			sql="select * from teacher ";
			Statement stmt =con.createStatement();
			rs=stmt.executeQuery(sql);
									
			
			
		//stmt.close();
			out.println("<table cellspacing='0' width='380px' border='1'>");
			out.println("<tr>");
			out.println("<td>  Teacher_id</td>");
			out.println("<td> Teacher_name</td>");
			out.println("<td> Teacher_age</td>");
		    out.println("<td> DOB</td>");
			out.println("<td> DOJ </td>");
			out.println("<td> Teches_subject</td>");
			out.println("<td> Sub_id</td>");
			out.println("<td> Align </td>");
			out.println("<td> Delete </td>");
			
			out.println("</tr>");
			while(rs.next())
			{
				
								
				out.println("<tr>");
				
				
				out.println("<td >" + rs.getString("Teacher_id") + "</td >");
				out.println("<td >" + rs.getString("Teacher_name") +"</td >");
				out.println("<td > "+ rs.getString("Teacher_age") + "</td >");
				out.println("<td >" + rs.getString("DOB") + "</td >");
				out.println("<td >" + rs.getString("DOJ") + "</td >");
				out.println("<td > "+ rs.getString("Teches_subject") +"</td >");
				out.println("<td > "+ rs.getString("Sub_id") +"</td >");
				out.println("<td > " + "<a href ='AlignTeacher?Teacher_id=" +rs.getString("Teacher_id") + "'> ALIGN/EDIT </a>" + "</td >");
				out.println("<td > " + "<a href ='DelTeacher?Teacher_id=" +rs.getString("Teacher_id") +"' > DELETE</a>" + "</td >");
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
