<%@page import="tech.codehunt.dao.LoginDaoImpl"%>
<%@page import="tech.codehunt.pojo.ReadLoginPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .login-container {
            margin:10px;
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%  
  ReadLoginPojo rlp = new LoginDaoImpl().readLogin();
%>
    <div class="login-container">
        <h2>Change Username or password</h2>
        <form action="Change" method="post">
            <input type="text" name="username" placeholder="Username" value="<%=rlp.getUsername()%>" required><br>
            <input type="password" name="password" placeholder="Password" value="<%=rlp.getPassword()%>" required><br>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
    