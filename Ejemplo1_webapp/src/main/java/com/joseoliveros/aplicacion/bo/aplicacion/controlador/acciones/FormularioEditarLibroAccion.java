package com.joseoliveros.aplicacion.bo.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Libro;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioEditarLibroAccion extends Accion {

    private static final Logger log = Logger.getLogger(FormularioEditarLibroAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto FormularioEditarLibroAccion...");
        String isbn = request.getParameter("isbn");
        List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
        Libro libro = Libro.buscarPorClave(isbn);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        request.setAttribute("libro", libro);
        log.info("Retornando FormularioEditarLibro.jsp");
        return "FormularioEditarLibro.jsp";
    }
}
