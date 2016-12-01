package com.joseoliveros.aplicacion.beans;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import com.joseoliveros.aplicacion.servicios.ServicioLibros;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class FormularioLibroManagedBean {
    
    private String isbn;
    private String titulo;
    private String categoria;
    private List<SelectItem> listaDeCategorias;
    private List<Libro> listaDeLibros;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<SelectItem> getListaDeCategorias() {
        return listaDeCategorias;
    }

    public void setListaDeCategorias(List<SelectItem> listaDeCategorias) {
        this.listaDeCategorias = listaDeCategorias;
    }

    public List<Libro> getListaDeLibros() {
        return listaDeLibros;
    }

    public void setListaDeLibros(List<Libro> listaDeLibros) {
        this.listaDeLibros = listaDeLibros;
    }

    @PostConstruct
    public void iniciar() {
        listaDeLibros = getServicioLibros().buscarTodosLosLibros();
        
        List<Categoria> categorias = getServicioLibros().buscarCategoriasLibros();
        listaDeCategorias = new ArrayList<SelectItem>();
        for (Categoria categoria : categorias) {
            listaDeCategorias.add(new SelectItem(categoria.getId(), categoria.getDescripcion()));
        }
    }

    public void insertar(ActionEvent event) {
        getServicioLibros().insertarLibro(new Libro(isbn, titulo, new Categoria(Integer.parseInt(categoria))));
        setListaDeLibros(getServicioLibros().buscarTodosLosLibros());
        categoria = "0";
    }

    public void borrar(ActionEvent event) {
        UIComponent componente = event.getComponent();
        String isbn = componente.getAttributes().get("isbn").toString();
        getServicioLibros().borrarLibro(new Libro(isbn));
        setListaDeLibros(getServicioLibros().buscarTodosLosLibros());
    }

    public void filtrar(ValueChangeEvent event) {
        int idCategoria = Integer.parseInt(event.getComponent().getAttributes().get("value").toString());

        if (idCategoria != 0) {
            setListaDeLibros(getServicioLibros().buscarLibrosPorCategoria(idCategoria));
        } else {
            setListaDeLibros(getServicioLibros().buscarTodosLosLibros());
        }
    }

    public void editar(ActionEvent event) {
        UIComponent componente = event.getComponent();
        Libro libro = getServicioLibros().buscarLibroPorClave(componente.getAttributes().get("isbn").toString());
        isbn = libro.getIsbn();
        titulo = libro.getTitulo();
    }

    public void formularioInsertar(ActionEvent event) {
        isbn = "";
        titulo = "";
    }

    public void salvar(ActionEvent event) {
        getServicioLibros().salvarLibro(new Libro(isbn, titulo, new Categoria(Integer.parseInt(categoria))));
        setListaDeLibros(getServicioLibros().buscarTodosLosLibros());
        categoria = "0";
    }

    public ServicioLibros getServicioLibros() {
        ApplicationContext context = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        return (ServicioLibros) context.getBean("servicioLibros");
    }
}
