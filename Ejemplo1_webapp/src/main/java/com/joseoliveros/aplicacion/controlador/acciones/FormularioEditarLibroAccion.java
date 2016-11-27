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

public class FormularioEditarLibroAccion extends Accion {

    private static final Logger log = Logger.getLogger(FormularioEditarLibroAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto FormularioEditarLibroAccion...");
        String isbn = request.getParameter("isbn");
        DAOFactory factoria = DAOAbstractFactory.getInstance();
        LibroDAO libroDAO = factoria.getLibroDAO();
        CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
        List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
        Libro libro = libroDAO.buscarPorClave(isbn);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        request.setAttribute("libro", libro);
        log.info("Retornando FormularioEditarLibro.jsp");
        return "FormularioEditarLibro.jsp";
    }
}
