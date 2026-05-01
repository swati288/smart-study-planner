<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<header><h1>Dashboard</h1></header>

<nav>
<a href="dashboard.jsp">Home</a>
<a href="addTask.jsp">Add Task</a>
<a href="viewTask.jsp">View Tasks</a>
<a href="logout.jsp">Logout</a>
</nav>

<div class="container">
<h2>Welcome <%= session.getAttribute("user") %></h2>
<p>Manage your daily study tasks here.</p>
</div>

</body>
</html>