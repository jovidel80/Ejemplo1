package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.servicios.ServicioLibros;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalvarLibroAccion extends Accion {

    private static final Logger log = Logger.getLogger(SalvarLibroAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto SalvarLibroAccion...");
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        ServicioLibros servicioLibros = (ServicioLibros)  getBean("servicioLibros", request);
        Categoria objetoCategoria = new Categoria(Integer.parseInt(categoria));
        Libro libro = new Libro(isbn, titulo, objetoCategoria);
        servicioLibros.salvarLibro(libro);

        log.info("Retornando MostrarLibros.do");
        return "MostrarLibros.do";
    }
}
