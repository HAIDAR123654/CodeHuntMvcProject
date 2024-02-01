<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Login</title>
<link rel="stylesheet" href="css/tooplate-style.css">
<style>
  .st{
    margin: 10px;
    padding: 10px 5px;
    border-radius: 4px;
  }
  button{
    padding:6px 40px;
    background: #80ff80;
    color: black;
    font-weight: bolder;
    border-radius: 4px;
  }
</style>
</head>
<body>

    <h1 style="text-align: center;">Admin Login Here..</h1>
       <%@include file="messageprint.jsp" %>
	<form style="text-align: center;" action="Login" method="post">
	      <input class="st" type="text" name="username" placeholder="username"/><br>
	      <input  class="st" type="text" name="password" placeholder="password"/><br>
	      <button>LOGIN</button>
	</form>
</body>
</html>

