package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.*;
import com.joseoliveros.aplicacion.dao.jpa.CategoriaDAOJPAImpl;
import com.joseoliveros.aplicacion.dao.jpa.LibroDAOJPAImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MostrarLibrosAccion extends Accion {

    private static final Logger log = Logger.getLogger(MostrarLibrosAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto MostrarLibrosAccion...");
        DAOFactory factoria = DAOAbstractFactory.getInstance();
        CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
        LibroDAO libroDAO = factoria.getLibroDAO();
        List<Libro> listaDeLibros = libroDAO.buscarTodos();
        List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        log.info("Retornando MostrarLibros.jsp");
        return "MostrarLibros.jsp";
    }
}
