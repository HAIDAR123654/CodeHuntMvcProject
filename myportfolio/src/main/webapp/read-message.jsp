<%@page import="tech.codehunt.pojo.MessagePojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tech.codehunt.dao.MessageDaoImpl" %>

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
    <title>User Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            height: 100vh;
        }

        .container {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
        }

        .back-link {
            color: #007bff;
            text-decoration: none;
            margin-bottom: 20px;
            display: block;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        td {
            background-color: #fff;
        }

        .delete-btn {
            background-color: #dc3545;
            color: #fff;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 4px;
        }

        .delete-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
         String user = (String)session.getAttribute("login");
        %>
       <h3>Hello <%=user %></h3>
   
       <%@include file="messageprint.jsp" %>
        <a class="back-link" href="admin.jsp">Go Back Admin Page</a>
      
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Message</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
	          <%
		      MessageDaoImpl md = new MessageDaoImpl();
		      ArrayList<MessagePojo> al =  md.read();
		      int i=1;
		       for(MessagePojo mp: al){ 
		      %>
                <tr>
                    <td><%=i%></td>
                    <td><%=mp.getName() %></td>
                    <td><%=mp.getEmail() %></td>
                    <td><%=mp.getMessage() %></td>
                    <td>
                    <form action="Message" method="post">
			           <input  type="hidden" value="deletemessage" name="check"/>
			           <input type="hidden" value="<%=mp.getSn()%>" name="sn"/>
			            <button class="delete-btn">Delete</button>
			           </form>
                    </td>
                </tr>
                <%
               i++;
                }
               %>
                <!-- Add more rows as needed -->
            </tbody>
        </table>
    </div>
</body>
</html>
    