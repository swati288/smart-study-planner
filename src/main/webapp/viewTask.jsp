<%@ page import="java.sql.*" %>
<%@ page import="com.planner.DBConnection" %>

<html>
<head>
    <title>View Tasks</title>
    <link rel="stylesheet" href="css/style.css">

    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background-color: #2c3e50;
            color: white;
            padding: 10px;
        }

        td {
            padding: 8px;
            text-align: center;
        }

        .complete-btn {
            background-color: #27ae60;
            color: white;
            padding: 6px 12px;
            text-decoration: none;
            border-radius: 4px;
        }

        .delete-btn {
            background-color: #e74c3c;
            color: white;
            padding: 6px 12px;
            text-decoration: none;
            border-radius: 4px;
        }

        .complete-btn:hover,
        .delete-btn:hover {
            opacity: 0.8;
        }
    </style>
</head>

<body>

<h2>Your Tasks</h2>

<table border="1">

<tr>
    <th>Topic</th>
    <th>Subject</th>
    <th>Date</th>
    <th>Status</th>
    <th>Actions</th>
</tr>

<%
try {

    Connection con = DBConnection.getConnection();

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery("SELECT * FROM tasks");

    while(rs.next()) {
%>

<tr>

    <td>
        <%= rs.getString("topic") %>
    </td>

    <td>
        <%= rs.getString("subject") %>
    </td>

    <td>
        <%= rs.getString("study_date") %>
    </td>

    <td>
        <%= rs.getString("status") %>
    </td>

    <td>

        <% if(!"Completed".equals(rs.getString("status"))) { %>

            <a class="complete-btn"
               href="updateTask?id=<%= rs.getInt("id") %>">
               Mark Completed
            </a>

        <% } %>

        <a class="delete-btn"
           href="deleteTask?id=<%= rs.getInt("id") %>"
           onclick="return confirm('Are you sure you want to delete this task?');">
           Delete
        </a>

    </td>

</tr>

<%
    }

    rs.close();
    st.close();
    con.close();

} catch(Exception e) {

    out.println(e);

}
%>

</table>

</body>
</html>