package com.joseoliveros.aplicacion.servicios;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.CategoriaDAO;
import com.joseoliveros.aplicacion.dao.DAOAbstractFactory;
import com.joseoliveros.aplicacion.dao.DAOFactory;
import com.joseoliveros.aplicacion.dao.LibroDAO;

import java.util.List;

public class ServicioLibrosImpl implements ServicioLibros {

    private LibroDAO libroDAO = null;
    private CategoriaDAO categoriaDAO = null;

    public ServicioLibrosImpl() {
        DAOFactory factory = DAOAbstractFactory.getInstance();
        libroDAO = factory.getLibroDAO();
        categoriaDAO = factory.getCategoriaDAO();
    }

    @Override
    public void salvarLibro(Libro libro) {
        libroDAO.salvar(libro);
    }

    @Override
    public void borrarLibro(Libro libro) {
        libroDAO.borrar(libro);
    }

    @Override
    public List<Libro> buscarTodosLosLibros() {
        return libroDAO.buscarTodos();
    }

    @Override
    public List<Categoria> buscarCategoriasLibros() {
        return categoriaDAO.buscarTodos();
    }

    @Override
    public Libro buscarLibroPorClave(String isbn) {
        return libroDAO.buscarPorClave(isbn);
    }

    @Override
    public Categoria buscarCategoriaPorClave(int id) {
        return categoriaDAO.buscarPorClave(id);
    }

    @Override
    public List<Libro> buscarLibrosPorCategoria(int categoriaId) {
        Categoria categoria = categoriaDAO.buscarPorClave(categoriaId);
        return libroDAO.buscarPorCategoria(categoria);
    }
}
