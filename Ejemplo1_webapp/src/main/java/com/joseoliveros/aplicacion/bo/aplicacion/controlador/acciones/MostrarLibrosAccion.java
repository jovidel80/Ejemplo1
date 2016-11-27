package com.joseoliveros.aplicacion.bo.aplicacion.controlador.acciones;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MostrarLibrosAccion extends Accion {

    private static final Logger log = Logger.getLogger(MostrarLibrosAccion.class.getPackage().getName());

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        log.info("Ejecutanto MostrarLibrosAccion...");
        List<Libro> listaDeLibros = Libro.buscarTodos();
        List<Categoria> listaDeCategorias = Categoria.buscarTodos();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        log.info("Retornando MostrarLibros.jsp");
        return "MostrarLibros.jsp";
    }
}
