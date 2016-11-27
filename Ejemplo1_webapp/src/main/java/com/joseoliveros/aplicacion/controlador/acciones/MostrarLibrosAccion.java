package com.joseoliveros.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.CategoriaDAO;
import com.joseoliveros.aplicacion.dao.LibroDAO;
import com.joseoliveros.aplicacion.servicios.ServicioLibros;
import com.joseoliveros.aplicacion.servicios.impl.ServicioLibrosImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MostrarLibrosAccion extends Accion {

    private static final Logger log = Logger.getLogger(MostrarLibrosAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto MostrarLibrosAccion...");
        ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros", request);

        // Ya no necesitamos inyectar estas depencias, spring lo hace a traves del applicationcontext.xml

//        CategoriaDAO categoriaDAO = (CategoriaDAO) getBean("libroDAO");
//        LibroDAO libroDAO = (LibroDAO) getBean("categoriaDAO");
//        servicioLibros.setCategoriaDAO(categoriaDAO);
//        servicioLibros.setLibroDAO(libroDAO);
        List<Libro> listaDeLibros = servicioLibros.buscarTodosLosLibros();
        List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        log.info("Retornando MostrarLibros.jsp");
        return "MostrarLibros.jsp";
    }
}
