package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.CategoriaDAO;
import com.joseoliveros.aplicacion.dao.DAOAbstractFactory;
import com.joseoliveros.aplicacion.dao.DAOFactory;
import com.joseoliveros.aplicacion.dao.LibroDAO;
import com.joseoliveros.aplicacion.dao.jpa.CategoriaDAOJPAImpl;
import com.joseoliveros.aplicacion.dao.jpa.LibroDAOJPAImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

    private static final Logger log = Logger.getLogger(FiltrarLibrosPorCategoriaAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto FiltrarLibrosPorCategoriaAccion...");
        DAOFactory factoria = DAOAbstractFactory.getInstance();
        LibroDAO libroDAO = factoria.getLibroDAO();
        CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
        List<Libro> listaDeLibros = null;
        List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
        if (request.getParameter("categoria") == null ||
                request.getParameter("categoria").equals("seleccionar")) {
            listaDeLibros = libroDAO.buscarTodos();
        } else {
            Categoria categoriaSeleccionada = categoriaDAO.buscarPorClave(Integer.parseInt(request.getParameter("categoria")));
            listaDeLibros = libroDAO.buscarPorCategoria(categoriaSeleccionada);
        }
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        log.info("Retornando MostrarLibros.jsp");
        return "MostrarLibros.jsp";
    }
}
