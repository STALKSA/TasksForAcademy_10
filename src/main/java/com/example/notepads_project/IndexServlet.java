package com.example.notepads_project;

import java.io.*;
import java.sql.SQLException;

import com.example.notepads_project.model.DatabaseManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = "/index")
public class IndexServlet extends HttpServlet {

    private DatabaseManager managerData;

    public void init() {
        managerData = new DatabaseManager();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");



        // Hello

    }

    public void destroy() {
        try {
            managerData.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}