package com.example.notepads_project;

import java.io.*;
import java.sql.SQLException;

import com.example.notepads_project.model.DatabaseManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private DatabaseManager managerData;

    public void init() {
        managerData = new DatabaseManager();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            request.setAttribute("notebooks", managerData.getAllNotebooks());
            request.setAttribute("countries", managerData.getAllCountries());
            request.setAttribute("countryNotebookCounts", managerData.getCountryNotebookCounts());
            request.setAttribute("countryWithMostNotebooks", managerData.getCountryWithMostNotebooks());
            request.setAttribute("countryWithLeastNotebooks", managerData.getCountryWithLeastNotebooks());
            request.setAttribute("brandWithMostNotebooks", managerData.getBrandWithMostNotebooks());
            request.setAttribute("brandWithLeastNotebooks", managerData.getBrandWithLeastNotebooks());
            request.setAttribute("hardCoverNotebooks", managerData.getHardCoverNotebooks());
            request.setAttribute("softCoverNotebooks", managerData.getSoftCoverNotebooks());
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    public void destroy() {
        try {
            managerData.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}