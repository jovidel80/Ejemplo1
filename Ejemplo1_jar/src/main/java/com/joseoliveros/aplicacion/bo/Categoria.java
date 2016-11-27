package com.joseoliveros.aplicacion.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    private int id;

    private String descripcion;

    @OneToMany
    @JoinColumn(name = "categoria")
    private List<Libro> listaDeLibros;

    public Categoria() {

    }

    public Categoria(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        return id == categoria.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Libro> getListaDeLibros() {
        return listaDeLibros;
    }

    public void setListaDeLibros(List<Libro> listaDeLibros) {
        this.listaDeLibros = listaDeLibros;
    }

    public static List<Categoria> buscarTodos() {
        SessionFactory factory = HibernateHelper.getSessionFactory();
        Session session = factory.openSession();
        List<Categoria> listaDeCategorias = session.createQuery("from Categoria categoria").list();
        session.close();
        return listaDeCategorias;
    }

    public static Categoria buscarPorClave(int id) {
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query consulta = session.createQuery("from Categoria categoria where id=:id");
        consulta.setParameter("id", id);
        Categoria categoria = (Categoria) consulta.getSingleResult();
        session.close();
        return categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
