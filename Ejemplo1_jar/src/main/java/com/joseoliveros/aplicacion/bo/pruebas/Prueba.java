package com.joseoliveros.aplicacion.bo.pruebas;

import com.joseoliveros.aplicacion.bo.HibernateHelper;
import com.joseoliveros.aplicacion.bo.Libro;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Prueba {

    private static final Logger log = Logger.getLogger(Prueba.class.getPackage().getName());

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
//        Categoria categoria = new Categoria();
//        categoria.setId("8");
//        categoria.setDescripcion("prueba descripcion");
//        Libro libro = new Libro("9", "prueba", categoria);
//        libro.insertar();
        List<Libro> listaDeLibros = session.createQuery("from Libro libro").list();
        for (Libro libro : listaDeLibros) {
            System.out.println(libro.getIsbn());
            System.out.println(libro.getTitulo());
            System.out.println(libro.getCategoria().getDescripcion());
        }
        session.close();
    }
}
