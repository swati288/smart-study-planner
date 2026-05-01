<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<header><h1>Login</h1></header>

<div class="container">
<form action="LoginServlet" method="post">

Username:
<input type="text" name="username" required>

Password:
<input type="password" name="password" required>

<button type="submit">Login</button>

</form>
</div>

</body>
</html>