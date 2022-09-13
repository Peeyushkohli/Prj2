<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page  import =" java.sql.* " %>
<!DOCTYPE html>
<html>
<head  Teacher Alignment Report >
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h1>Teacher Alignment Report  </h1>
<% 	try 

{
	 ResultSet rs;
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learner","root","root");
	String sql;
	//PrintWriter out=response.getWriter();
	sql=("select Teacher_name ,Subject ,subject.toght_in_standard from teacher  inner join Subject  on teacher.Sub_id= subject.Subject_id;");
	PreparedStatement stmt=con.prepareStatement(sql);
	rs=stmt.executeQuery(sql);
	
	if(rs.next()==false)
							
	{
		out.println("No Records Found");
	}
	else 
	{
		%>
		<table  border ="1" >
		<div style ="text-align: center;">
		<tr><th>Teacher Name </th><th>Course </th><th>Tought in Standard</th></tr><%
		
	
		do
		{
		
		%>
			
		<tr><td><%=rs.getString(1) %> </td><td><%=rs.getString(2)%></td><td><%=rs.getString(3) %> </td></tr><% 
			
		}while(rs.next());
		
		%>
		
		</table>
		
		<%
	}
}
catch (Exception e)
{
		System.out.println(e);
}
out.println("<p><a href = 'MainPortal.jsp' >Home</a></p>");
%>

,
</body>
</html>