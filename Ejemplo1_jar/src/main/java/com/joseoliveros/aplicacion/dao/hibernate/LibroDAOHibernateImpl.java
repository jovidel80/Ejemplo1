package com.joseoliveros.aplicacion.dao.hibernate;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.LibroDAO;
import com.joseoliveros.aplicacion.dao.jpa.GenericDAOJPAImpl;

import java.util.List;

public class LibroDAOHibernateImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO {

    @Override
    public List<Libro> buscarPorCategoria(Categoria categoria) {
        return null;
    }
}
