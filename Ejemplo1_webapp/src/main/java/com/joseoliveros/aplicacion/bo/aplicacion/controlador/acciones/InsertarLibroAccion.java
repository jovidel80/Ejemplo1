package com.joseoliveros.aplicacion.bo.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
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
        Categoria objetoCategoria = new Categoria(Integer.parseInt(categoria));
        Libro libro = new Libro(isbn, titulo, objetoCategoria);
        libro.insertar();
        log.info("Retornando MostrarLibros.do");
        return "MostrarLibros.do";
    }
}
