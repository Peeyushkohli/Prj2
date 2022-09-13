<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			
		<%
		
		if(session.getAttribute("uname")== null)
		{
			response.sendRedirect("LA.jsp");
		}
		
		
		
		
		%>	
			
			
			
			Welcome ... ${uname}
			
			<a  href="MainPortal.jsp">ALL YOUR's Click to Enter Portal</a>
			<form action="Logout.jsp">
			
			<input type  ="submit" value ="LOGOUT">
			
			</form>
			
</body>
</html>