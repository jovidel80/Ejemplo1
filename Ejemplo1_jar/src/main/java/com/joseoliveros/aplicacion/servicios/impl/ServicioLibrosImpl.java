package com.joseoliveros.aplicacion.servicios.impl;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.dao.CategoriaDAO;
import com.joseoliveros.aplicacion.dao.DAOAbstractFactory;
import com.joseoliveros.aplicacion.dao.DAOFactory;
import com.joseoliveros.aplicacion.dao.LibroDAO;
import com.joseoliveros.aplicacion.servicios.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "servicioLibros")
public class ServicioLibrosImpl implements ServicioLibros {

    private LibroDAO libroDAO = null;
    private CategoriaDAO categoriaDAO = null;

    // NO hace falta inicializar estos beans en el constructor, ya que ahora se hacen a nivel de la clase Acción

    public ServicioLibrosImpl() {
//        DAOFactory factory = DAOAbstractFactory.getInstance();
//        libroDAO = factory.getLibroDAO();
//        categoriaDAO = factory.getCategoriaDAO();
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
//        libroDAO = (LibroDAO) context.getBean("libroDAO");
//        categoriaDAO = (CategoriaDAO) context.getBean("categoriaDAO");
//        System.out.println("Obteniendo beans a traves del contexto de Spring");
    }

    @Override
    public void insertarLibro(Libro libro) {
        libroDAO.insertar(libro);
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

    @Override
    public LibroDAO getLibroDao() {
        return libroDAO;
    }

    @Override
    @Autowired
    public void setLibroDAO(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    @Override
    public CategoriaDAO getCategoriaDao() {
        return categoriaDAO;
    }

    @Override
    @Autowired
    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
}
