package com.joseoliveros.aplicacion.dao;

import com.joseoliveros.aplicacion.dao.hibernate.CategoriaDAOHibernateImpl;
import com.joseoliveros.aplicacion.dao.jpa.CategoriaDAOJPAImpl;

public class CategoriaDAOFactory {

    public static CategoriaDAO getInstance() {
        String tipo = "JPA";
        if (tipo.equals("Hibernate")) {
            return new CategoriaDAOHibernateImpl();
        } else {
            return new CategoriaDAOJPAImpl();
        }
    }
}
