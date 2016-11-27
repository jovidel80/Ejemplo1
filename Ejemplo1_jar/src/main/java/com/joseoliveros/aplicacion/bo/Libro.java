package com.joseoliveros.aplicacion.bo;

import org.apache.log4j.Logger;

import javax.persistence.*;

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


    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
