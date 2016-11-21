package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.Libro;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertarLibroAccion extends Accion {

    private static final Logger log = Logger.getLogger(InsertarLibroAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto InsertarLibroAccion...");
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        Libro libro = new Libro(isbn, titulo, categoria);
        libro.insertar();
        log.info("Retornando MostrarLibros.do");
        return "MostrarLibros.do";
    }
}
