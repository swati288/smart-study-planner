package com.planner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            // Get values from form
            String username = req.getParameter("username");
            String subject = req.getParameter("subject");
            String topic = req.getParameter("topic");
            String studyDate = req.getParameter("study_date");
            String status = req.getParameter("status");

            Connection con = DBConnection.getConnection();

            if (con == null) {
                out.println("DB Connection Failed");
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO tasks(username, subject, topic, study_date, status) VALUES (?,?,?,?,?)"
            );

            ps.setString(1, username);
            ps.setString(2, subject);
            ps.setString(3, topic);
            ps.setString(4, studyDate);
            ps.setString(5, status);

            int i = ps.executeUpdate();

            if (i > 0) {
                res.sendRedirect(req.getContextPath() + "/dashboard.jsp");
            } else {
                out.println("Task not added");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("ERROR: " + e.getMessage());
        }
    }
}