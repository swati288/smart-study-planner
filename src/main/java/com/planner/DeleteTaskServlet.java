package com.planner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM tasks WHERE id=?"
            );

            ps.setInt(1, Integer.parseInt(req.getParameter("id")));

            ps.executeUpdate();

            res.sendRedirect("viewTask.jsp");

        } catch(Exception e) {

            res.getWriter().println(e);

        }
    }
}