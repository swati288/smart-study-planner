<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Task</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<header><h1>Add Study Task</h1></header>

<div class="container">
<form action="addTask" method="post">

    Username:
    <input type="text" name="username"><br>

    Subject:
    <input type="text" name="subject"><br>

    Topic:
    <input type="text" name="topic"><br>

    Date:
    <input type="date" name="study_date"><br>

    Status:
    <select name="status">
        <option>Pending</option>
        <option>Completed</option>
    </select><br>

    <input type="submit" value="Add Task">

</form>
</div>

</body>
</html>