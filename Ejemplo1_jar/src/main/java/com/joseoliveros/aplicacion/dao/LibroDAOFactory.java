package com.joseoliveros.aplicacion.dao;

import com.joseoliveros.aplicacion.dao.hibernate.LibroDAOHibernateImpl;
import com.joseoliveros.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class LibroDAOFactory {

    public static LibroDAO getInstance() {
        String tipo = "JPA";
        if (tipo.equals("Hibernate")) {
            return new LibroDAOHibernateImpl();
        } else {
            return new LibroDAOJPAImpl();
        }
    }
}
