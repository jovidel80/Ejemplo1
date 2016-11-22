package com.joseoliveros.aplicacion.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    private String id;

    private String descripcion;

    @OneToMany
    @JoinColumn(name = "categoria")
    private List<Libro> listaDeLibros;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria that = (Categoria) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
//        List<Categoria> listaDeCategorias = session.createQuery("from Categoria categoria").list();
        session.close();
        return null;
    }
}
