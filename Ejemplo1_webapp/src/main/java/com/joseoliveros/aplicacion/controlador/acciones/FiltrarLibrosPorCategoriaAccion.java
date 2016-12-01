package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.servicios.ServicioLibros;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

    private static final Logger log = Logger.getLogger(FiltrarLibrosPorCategoriaAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto FiltrarLibrosPorCategoriaAccion...");
        ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros", request);
        List<Libro> listaDeLibros = null;
        List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros();
        if (request.getParameter("categoria") == null ||
                request.getParameter("categoria").equals("seleccionar")) {
            listaDeLibros = servicioLibros.buscarTodosLosLibros();
        } else {
            listaDeLibros = servicioLibros.buscarLibrosPorCategoria(Integer.parseInt(request.getParameter("categoria")));
        }
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        log.info("Retornando MostrarLibros.jsp");
        return "MostrarLibros.jsp";
    }
}
