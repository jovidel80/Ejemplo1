package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.Libro;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormularioInsertarLibroAccion extends Accion {

    private static final Logger log = Logger.getLogger(FormularioInsertarLibroAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto FormularioInsertarLibroAccion...");
        List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        log.info("FormularioInsertarLibro.jsp");
        return "FormularioInsertarLibro.jsp";
    }
}
