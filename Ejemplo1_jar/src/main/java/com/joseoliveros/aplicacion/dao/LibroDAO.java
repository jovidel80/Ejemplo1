package com.joseoliveros.aplicacion.dao;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;

import java.util.List;

public interface LibroDAO extends GenericDAO<Libro, String> {

    public List<Libro> buscarPorCategoria(Categoria categoria);
}
