package com.joseoliveros.aplicacion.bo.pruebas;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Prueba {

    private static final Logger log = Logger.getLogger(Prueba.class.getPackage().getName());

    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;
        SessionFactory factory = null;

        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
            factory.close();
        }
    }
}
