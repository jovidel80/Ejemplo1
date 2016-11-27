package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.LibroDAO;
import com.joseoliveros.aplicacion.dao.jpa.LibroDAOJPAImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarLibroAccion extends Accion {

    private static final Logger log = Logger.getLogger(BorrarLibroAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto BorrarLibroAccion...");
        String isbn = request.getParameter("isbn");
        LibroDAO libroDAO = new LibroDAOJPAImpl();
        Libro libro = new Libro(isbn);
        libroDAO.borrar(libro);
        log.info("Retornando MostrarLibros.do");
        return "MostrarLibros.do";
    }
}
