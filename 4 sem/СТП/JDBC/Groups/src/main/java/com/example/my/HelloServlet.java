package com.example.my;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import db.Mytable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Table;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    int CommonSum = 0;
    public void init() { }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int year = Integer.parseInt(request.getParameter("year"));
        try {
            request.setAttribute("tables", Mytable.select(year));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/table.jsp").forward(request, response);
    }

    public void destroy() { }
}