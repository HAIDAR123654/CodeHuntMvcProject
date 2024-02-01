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
   String user = (String)session.getAttribute("username");
   %>
   <h3 style={color:red;}>Hello , this <%=user %> is already logedIn!</h3>
   
   <a href="/myportfolio/adminauth.jsp">Go Back to login page</a>
   
</body>
</html>