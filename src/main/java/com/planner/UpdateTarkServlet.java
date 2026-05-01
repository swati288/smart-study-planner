package com.planner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planner.DBConnection;
@WebServlet("/updateTask")
public class UpdateTarkServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse res)
throws IOException {

    try{
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
        "UPDATE tasks SET status='Completed' WHERE id=?");

        ps.setInt(1, Integer.parseInt(req.getParameter("id")));

        ps.executeUpdate();

        res.sendRedirect("dashboard.jsp");

    }catch(Exception e){
        res.getWriter().println(e);
    }
}
}