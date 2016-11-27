package com.joseoliveros.aplicacion.dao.jpa;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.CategoriaDAO;
import com.joseoliveros.aplicacion.dao.LibroDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO {


    @Override
    public List<Libro> buscarPorCategoria(Categoria categoria) {
        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
        EntityManager manager = factoriaSession.createEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
        TypedQuery<Libro> consulta = manager.createQuery(
                "Select l from Libro l where l.categoria=?1",
                Libro.class);
        consulta.setParameter(1, categoria);
        List<Libro> listaDeLibros = null;
        try {
            listaDeLibros = consulta.getResultList();
        } finally {
            manager.close();
        }
        return listaDeLibros;
    }
}
