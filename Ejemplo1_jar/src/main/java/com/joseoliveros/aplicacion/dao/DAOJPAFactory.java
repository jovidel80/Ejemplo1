package com.joseoliveros.aplicacion.dao;

import com.joseoliveros.aplicacion.dao.jpa.CategoriaDAOJPAImpl;
import com.joseoliveros.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class DAOJPAFactory implements DAOFactory {

    @Override
    public CategoriaDAO getCategoriaDAO() {
        return new CategoriaDAOJPAImpl();
    }

    @Override
    public LibroDAO getLibroDAO() {
        return new LibroDAOJPAImpl();
    }
}
