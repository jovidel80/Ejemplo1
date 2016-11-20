package com.joseoliveros.aplicacion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProccess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProccess(request, response);
    }

    private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("MostrarLibros.do");
    }
}
