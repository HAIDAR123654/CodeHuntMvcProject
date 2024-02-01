<%
   String data = (String)session.getAttribute("login");
  if(data==null){
	  response.sendRedirect("adminauth.jsp");
	  return;
  }
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
            color: #333;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        nav {
            background-color: #eee;
            padding: 10px;
            display: flex;
            justify-content: space-around;
            align-items: center;
            flex-wrap: wrap;
        }

        nav a , button{
            text-decoration: none;
            color: #333;
            margin: 10px;
            padding: 5px 10px;
            border: 1px solid #333;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        nav a:hover , button{
            background-color: #333;
            color: #fff;
        }

        button{
            cursor: pointer;
        }
        section {
            padding: 20px;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>

<body>
    <header>
       <%@include file="messageprint.jsp" %>
	   <%
	   String user = (String)session.getAttribute("login");
	   %>
      <h3>Hello <%=user %>!</h3>
    </header>

    <nav>
        <a href="uploadproject.jsp">Upload Project</a>
        <a href="deleteproject.jsp">Delete Project</a>
        <a href="uploadedu.jsp">Upload Education</a>
        <a href="read-message.jsp">Read All Messages</a>
        <a href="change.jsp">Change ID or Password</a>
        <a href="index.jsp">Go to Home Page</a>
  
        
        <form action="Logout" method="post">
           <button>Logout</button>
        </form>
    </nav>

    <section>
        <!-- Content Goes Here -->
    </section>

    <footer>
        &copy; 2024 Admin Page
    </footer>
</body>

</html>
