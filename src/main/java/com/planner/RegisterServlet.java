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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            Connection con = DBConnection.getConnection();

            if (con == null) {
                out.println("DB Connection Failed");
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(username,password) VALUES (?,?)"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            int i = ps.executeUpdate();

            if (i > 0) {
                // 🔥 BEST PRACTICE FIX
                res.sendRedirect(req.getContextPath() + "/login.jsp");
            } else {
                out.println("Registration Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("ERROR: " + e.getMessage());
        }
    }
}