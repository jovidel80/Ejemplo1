package com.joseoliveros.aplicacion.servicios;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;

import java.util.List;

public interface ServicioLibros {

    void salvarLibro(Libro libro);
    void borrarLibro(Libro libro);
    List<Libro> buscarTodosLosLibros();
    List<Categoria> buscarCategoriasLibros();
    Libro buscarLibroPorClave(String isbn);
    Categoria buscarCategoriaPorClave(int id);
    List<Libro> buscarLibrosPorCategoria(int categoriaId);
}
