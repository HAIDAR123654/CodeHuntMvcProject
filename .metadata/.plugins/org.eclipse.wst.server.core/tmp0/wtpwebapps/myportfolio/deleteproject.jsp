<%@page import="tech.codehunt.pojo.ProjectPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tech.codehunt.dao.ProjectDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>All Projects</title>
<style>
  *{
   padding:0;
   margin:0;
  }
   h2{
      width:100%;
      height:40px;
      background: black;
      color:white;
      line-height: 40px;
      text-align: center;
   }
.section {
            display: flex;
            justify-content: space-around; /* Center the content horizontally */
            align-items: center; /* Center the content vertically */
            flex-wrap:wrap;
            background-color: #f4f4f4;
            gap:20px;
        }

        .project {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .project img {
            max-width: 90%;
            height: auto;
            border-radius: 4px;
            margin-bottom: 10px;
        }

        button {
            padding: 10px;
            background-color: #dc3545;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width:90%;
        }

        button:hover {
            background-color: orange;
        }
</style>
</head>

<body>
	<header>
		<h2>Your All Projects</h2>
	</header>
	<%@include file="messageprint.jsp"%>
	<%
       ArrayList<ProjectPojo>  alpp =  new ProjectDaoImpl().readProject();              
       for(ProjectPojo p : alpp){
    %>
	<div class="section">

		<div class="project">
		  <img src="images/myproject/<%=p.getFilename() %>" alt="Project Image">
		  <form action="Project" method="post">
			<input type="hidden" value="deleteproject" name="check" /> 
			<input type="hidden" value="<%=p.getSn()%>" name="sn" /> 
			<input type="hidden" value="<%=p.getFilename()%>" name="filename" />
			<button>Delete</button>
		  </form>
		</div>
	</div>

	<%
          }
    %>
</body>

</html>
