package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.Libro;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLibroAccion extends Accion {

    private static final Logger log = Logger.getLogger(BorrarLibroAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto BorrarLibroAccion...");
        String isbn = request.getParameter("isbn");
        Libro libro = new Libro(isbn);
        libro.borrar();
        log.info("Retornando MostrarLibros.do");
        return "MostrarLibros.do";
    }
}
