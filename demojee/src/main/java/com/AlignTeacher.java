package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlignTeacher
 */

//@WebServlet("/AlignTeacher")
public class AlignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	int row; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlignTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		
	
		
		
		//int id =Integer.parseInt(tempid);
		String Tid=request.getParameter("Teacher_id");
		//Integer  tid =Integer.parseInt(Tid);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
			
			pst=con.prepareStatement("select Teacher_id ,Teacher_name,Teches_subject,Sub_id  from teacher where Teacher_id=?");
			pst.setString(1, Tid);
			Statement stmt =con.createStatement();
			rs=pst.executeQuery();
									
					
			
			
		
			while(rs.next())
			{
				
				out.print("<form action='AlignEditTeacher?Teacher_id='  method='Post'>" );
				
				out.print("<table>");
				out.print("<tr> <td>Teacher_id> </td> <td> <input type='hidden' name='tid ' Teacher_id='eid' value = '"+rs.getString("Teacher_id")+"'/> </td></tr>");		
				out.print("<tr> <td>Teacher_name </td> <td> <input type='text' name='Teacher_name' Teacher_id='Teacher_name'  value = '"+rs.getString("Teacher_name")+"'/> </td></tr>");		
				//out.print("<tr> <td>Teacher_age> </td> <td> <input type='text' name=' Teacher_age '  value = '"+rs.getString("Teacher_age")+"'/> </td></tr>");	
				//out.print("<tr> <td>DOB > </td> <td> <input type='hidden' name='DOB '  value = '"+rs.getString("DOB")+"'/> </td></tr>");	
				//out.print("<tr> <td>DOJ  > </td> <td> <input type='text' name='DOJ ' value = '"+rs.getString("DOJ")+"'/> </td></tr>");	
				out.print("<tr> <td>Teches_subject> </td> <td> <input type='text' name='Teches_subject' Teacher_id='Teches_subject' value = '"+rs.getString("Teches_subject")+"'/> </td></tr>");	
				out.print("<tr> <td>Sub_id> </td> <td> <input type='text' name='Sub_id ' Teacher_id='Sub_id' value = '"+rs.getString("Sub_id")+"'/> </td></tr>");	
				//out.println("<td > " + "<a href ='AlignEditTeacher?Teacher_id=" +rs.getString("Teacher_id") + "'> ALIGN/EDIT</a>" + "</td >");
				
				out.print("<tr> <tdcolspan='2'> <input type='submit' value='Align-Edit'/></td></tr>");	
				
				out.print("</table>");
				//out.println("</form>");
			}
			
			out.println("</table>");
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
