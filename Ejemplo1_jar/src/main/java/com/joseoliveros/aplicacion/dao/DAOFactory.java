package com.joseoliveros.aplicacion.dao;

public interface DAOFactory {

    CategoriaDAO getCategoriaDAO();

    LibroDAO getLibroDAO();
}
