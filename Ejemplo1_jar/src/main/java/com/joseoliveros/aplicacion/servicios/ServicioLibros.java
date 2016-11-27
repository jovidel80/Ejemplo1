package com.joseoliveros.aplicacion.servicios;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.CategoriaDAO;
import com.joseoliveros.aplicacion.dao.LibroDAO;

import java.util.List;

public interface ServicioLibros {

    void insertarLibro(Libro libro);

    void salvarLibro(Libro libro);

    void borrarLibro(Libro libro);

    List<Libro> buscarTodosLosLibros();

    List<Categoria> buscarCategoriasLibros();

    Libro buscarLibroPorClave(String isbn);

    Categoria buscarCategoriaPorClave(int id);

    List<Libro> buscarLibrosPorCategoria(int categoriaId);

    LibroDAO getLibroDao();

    void setLibroDAO(LibroDAO libroDAO);

    CategoriaDAO getCategoriaDao();

    void setCategoriaDAO(CategoriaDAO categoriaDAO);
}
