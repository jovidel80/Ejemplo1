package com.joseoliveros.aplicacion.bo.pruebas;

import com.joseoliveros.aplicacion.bo.Libro;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Prueba {

    private static final Logger log = Logger.getLogger(Prueba.class.getPackage().getName());

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("arquitecturaJava");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);
        List<Libro> lista = consulta.getResultList();
        for (Libro libro : lista) {
            System.out.println(libro);
        }
    }
}
