package com.joseoliveros.aplicacion.bo.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

    private static final Logger log = Logger.getLogger(FiltrarLibrosPorCategoriaAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto FiltrarLibrosPorCategoriaAccion...");
        List<Libro> listaDeLibros = null;
        List<Categoria> listaDeCategorias = Categoria.buscarTodos();
        if (request.getParameter("categoria") == null ||
                request.getParameter("categoria").equals("seleccionar")) {
            listaDeLibros = Libro.buscarTodos();
        } else {
            Categoria categoriaSeleccionada = Categoria.buscarPorClave(Integer.parseInt(request.getParameter("categoria")));
            listaDeLibros = Libro.buscarPorCategoria(categoriaSeleccionada);
        }
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        log.info("Retornando MostrarLibros.jsp");
        return "MostrarLibros.jsp";
    }
}
