package com.example.bootstrapapp;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloPage", value = "/hello")
public class WelcomePage extends HttpServlet {
    private Valid valid;

    public void init() {
        valid = new Valid();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        valid.setEmail(request.getParameter("email"));
        valid.setNumber(request.getParameter("number"));
        valid.validMain();

        if (valid.isCorrectEmail() && valid.isCorrectNumber()) {          // валидация V
            request.setAttribute("successValidation", "Thank you!");
            request.getRequestDispatcher("sus.jsp").forward(request, response);
            valid.resetData();
            String pointEmail = valid.getEmail();
            String pointNumber = valid.getNumber();
            String sql = "INSERT INTO \"requestWP\" (email, number) VALUES ('" + pointEmail + "','" + pointNumber + "');";
            Connection connection;
            Statement statement;
            String url = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String password = "zn23102010";
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.createStatement();
                statement.execute(sql);
            } catch (SQLException |ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {                                                        // валидация Х
            if (!valid.isCorrectEmail() && valid.isCorrectNumber())
                request.setAttribute("messageEmail", "Incorrect email");
                request.setAttribute("messageNumber", "Incorrect number");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                valid.resetData();
        }
            if (!valid.isCorrectEmail()) {
                request.setAttribute("messageEmail", "Incorrect email");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                valid.resetData();
            if (valid.isCorrectNumber()) {
                request.setAttribute("messageNumber", "Incorrect number");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                valid.resetData();
            }
        }
    }

    public void destroy() {
    }
}