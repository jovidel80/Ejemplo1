package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.Libro;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

    private static final Logger log = Logger.getLogger(FiltrarLibrosPorCategoriaAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto FiltrarLibrosPorCategoriaAccion...");
        List<Libro> listaDeLibros = null;
        List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
        if (request.getParameter("categoria") == null ||
                request.getParameter("categoria").equals("seleccionar")) {
            listaDeLibros = Libro.buscarTodos();
        } else {
            listaDeLibros = Libro.buscarPorCategoria(request
                    .getParameter("categoria"));
        }
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        log.info("Retornando MostrarLibros.jsp");
        return "MostrarLibros.jsp";
    }
}
