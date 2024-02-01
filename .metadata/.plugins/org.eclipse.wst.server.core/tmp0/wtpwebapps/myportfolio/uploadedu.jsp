<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Education Form</title>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input {
            width: 100%;
            margin-bottom: 10px;
            padding: 8px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
             background-color: #333;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: orange;
        }
    </style>
</head>
<body>
    <%@include file="messageprint.jsp" %>
   
    <form action="Education" method="post">
     <h3>Fill your education details here</h3>
        <input type="text" name="title" placeholder="Title"/><br>
        <input type="text" name="subtitle" placeholder="Subtitle"/><br>
        <input type="text" name="desc" placeholder="Description"/><br>
        <input type="text" name="year" placeholder="Year"/><br>
        <button>Upload</button>
    </form>
</body>
</html>
