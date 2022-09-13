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
 * Servlet implementation class Align
 */
public class Align extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	int row;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Align() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		
		//String tempid=request.getParameter("u");
		
		
		//int id =Integer.parseInt(tempid);
		String Tid=request.getParameter("id");
		Integer  tid =Integer.parseInt(Tid);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
			
			pst=con.prepareStatement("select * from student where id=?");
			pst.setString(1, Tid);
			Statement stmt =con.createStatement();
			rs=pst.executeQuery();
									
					
			
			
		
			while(rs.next())
			{
				
				//out.print("<form action='AlignEdit'  method='Post'>" );
				
				out.print("<table>");
				out.print("<tr> <td>Student id > </td> <td> <input type='text' name='tid '  value = '"+rs.getString("id")+"'/> </td></tr>");		
				out.print("<tr> <td>NAME> </td> <td> <input type='text' name='tName'   value = '"+rs.getString("Name")+"'/> </td></tr>");		
				out.print("<tr> <td>AGE> </td> <td> <input type='text' name=' tage '  value = '"+rs.getString("age")+"'/> </td></tr>");	
				out.print("<tr> <td>Standard > </td> <td> <input type='text' name='tStandard '  value = '"+rs.getString("Standard")+"'/> </td></tr>");	
				out.print("<tr> <td>Subject > </td> <td> <input type='text' name='tSubject' value = '"+rs.getString("Subject")+"'/> </td></tr>");	
				out.print("<tr> <td>Subject_id> </td> <td> <input type='text' name='tSubject_id '  value = '"+rs.getString("Subject_id")+"'/> </td></tr>");	
				out.println("<td > " + "<a href ='AlignEdit?id=" +rs.getString("id") + "'> ALIGN/EDIT</a>" + "</td >");
				
				//out.print("<tr> <tdcolspan='2'> <input type='submit' value='Align-Edit'/></td></tr>");	
				
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
