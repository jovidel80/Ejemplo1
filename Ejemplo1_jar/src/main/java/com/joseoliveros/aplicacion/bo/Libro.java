package com.joseoliveros.aplicacion.bo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    private static final Logger log = Logger.getLogger(Libro.class.getPackage().getName());

    @Id
    private String isbn;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        return isbn.equals(libro.isbn);

    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    public Libro() {
        
    }

    public Libro(String isbn) {
        this.isbn = isbn;
    }

    public Libro(String isbn, String titulo, Categoria categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static List buscarTodasLasCategoria() {
        SessionFactory factory = HibernateHelper.getSessionFactory();
        log.info("Obteniendo SessionFactory");
        Session session = factory.openSession();
        log.info("Obteniendo Session");
        String consulta = "select distinct libro.categoria from Libro libro";
        List listaDeCategoria = session.createQuery(consulta).list();
        log.info("Ejecutando consulta: " + consulta);
        session.close();
        log.info("Cerrando Session");
        log.info("Retornando lista de categorias: " + listaDeCategoria);
        return listaDeCategoria;
    }

    public void insertar() {
        SessionFactory factory = HibernateHelper.getSessionFactory();
        log.info("Obteniendo SessionFactory");
        Session session = factory.openSession();
        log.info("Obteniendo Session");
        session.beginTransaction();
        log.info("Iniciando Transaccion");
        session.save(this);
        log.info("Insertando Libro: " + this.getIsbn() + " " + this.getTitulo() + " " + this.getCategoria());
        session.getTransaction().commit();
        log.info("Efectuando commit");
        session.close();
        log.info("Cerrando Session");
    }

    public static List<Libro> buscarTodos() {
        SessionFactory factory = HibernateHelper.getSessionFactory();
        log.info("Obteniendo SessionFactory");
        Session session = factory.openSession();
        log.info("Obteniendo Session");
        List listaDeLibros = session.createQuery("from Libro libro right join fetch libro.categoria").list();
        log.info("Retornando listaDeLibros: " + listaDeLibros);
        session.close();
        log.info("Cerrando Session");
        return listaDeLibros;
    }

    public void borrar() {
        SessionFactory factory = HibernateHelper.getSessionFactory();
        log.info("Obteniendo SessionFactory");
        Session session = factory.openSession();
        log.info("Obteniendo Session");
        session.beginTransaction();
        session.delete(this);
        session.getTransaction().commit();
        session.close();
        log.info("Cerrando Session");
    }

    public static Libro buscarPorClave(String isbn) {
        SessionFactory factory = HibernateHelper.getSessionFactory();
        log.info("Obteniendo SessionFactory");
        Session session = factory.openSession();
        log.info("Obteniendo Session");
        Libro libro = session.get(Libro.class, isbn);
        session.close();
        log.info("Cerrando Session");
        return libro;
    }

    public void salvar() {
        SessionFactory factory = HibernateHelper.getSessionFactory();
        log.info("Obteniendo SessionFactory");
        Session session = factory.openSession();
        log.info("Obteniendo Session");
        session.beginTransaction();
        session.saveOrUpdate(this);
        session.getTransaction().commit();
        session.close();
        log.info("Cerrando Session");
    }

    public static List<Libro> buscarPorCategoria(Categoria categoria) {
        SessionFactory factory = HibernateHelper.getSessionFactory();
        log.info("Obteniendo SessionFactory");
        Session session = factory.openSession();
        log.info("Obteniendo Session");
        Query consulta = session.createQuery("from Libro libro where libro.categoria=:categoria");
        consulta.setParameter("categoria", categoria);
        List listaDeLibros = consulta.getResultList();
        session.close();
        log.info("Cerrando Session");
        return listaDeLibros;
    }

    @Override
    public String   toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
