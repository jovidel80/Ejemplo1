package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.servicios.ServicioLibros;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioEditarLibroAccion extends Accion {

    private static final Logger log = Logger.getLogger(FormularioEditarLibroAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto FormularioEditarLibroAccion...");
        String isbn = request.getParameter("isbn");
        ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros", request);
        List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros();
        Libro libro = servicioLibros.buscarLibroPorClave(isbn);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        request.setAttribute("libro", libro);
        log.info("Retornando FormularioEditarLibro.jsp");
        return "FormularioEditarLibro.jsp";
    }
}
