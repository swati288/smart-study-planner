<%@ page import="java.sql.*" %>
<%@ page import="com.planner.DBConnection" %>

<html>
<head>
<title>View Tasks</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Your Tasks</h2>

<table border="1">
<tr>
    <th>Topic</th>
    <th>Subject</th>
    <th>Date</th>
    <th>Status</th>
</tr>

<%
try {
    Connection con = DBConnection.getConnection();
    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery("SELECT * FROM tasks");

    while(rs.next()) {
%>

<tr>
    <td><%= rs.getString("topic") %></td>
    <td><%= rs.getString("subject") %></td>
    <td><%= rs.getString("study_date") %></td>
    <td><%= rs.getString("status") %></td>
</tr>

<%
    }
} catch(Exception e) {
    out.println(e);
}
%>

</table>

</body>
</html>