package com.joseoliveros.aplicacion.controlador;

import com.joseoliveros.aplicacion.controlador.acciones.Accion;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControladorLibros extends HttpServlet {

    private static final long serialVersionUID = -2978402334741404345L;

    private static final Logger log = Logger.getLogger(ControladorLibros.class.getPackage().getName());

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher despachador = null;
        String url = request.getServletPath();
        log.info("");
        log.info("|---------------------New Request --------------------|");
        log.info("Servlet path: " + request.getServletPath());
        Accion accion = Accion.getAccion(getNombreAccion(url));
        log.info("Obteniendo accion de la url: " + getNombreAccion(url));
        String accionString = accion.ejecutar(request, response);
        despachador = request.getRequestDispatcher(accionString);
        log.info("Realizando despachador hacia: " + accionString);
        despachador.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private String getNombreAccion(String url) {
        return url.substring(1, url.length() - 3);
    }
}
