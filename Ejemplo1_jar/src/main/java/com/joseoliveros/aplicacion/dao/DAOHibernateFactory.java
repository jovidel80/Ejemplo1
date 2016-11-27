package com.joseoliveros.aplicacion.dao;

import com.joseoliveros.aplicacion.dao.hibernate.CategoriaDAOHibernateImpl;
import com.joseoliveros.aplicacion.dao.hibernate.LibroDAOHibernateImpl;

public class DAOHibernateFactory implements DAOFactory {

    @Override
    public CategoriaDAO getCategoriaDAO() {
        return new CategoriaDAOHibernateImpl();
    }

    @Override
    public LibroDAO getLibroDAO() {
        return new LibroDAOHibernateImpl();
    }
}
