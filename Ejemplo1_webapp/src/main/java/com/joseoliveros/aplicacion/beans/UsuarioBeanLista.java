package com.joseoliveros.aplicacion.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class UsuarioBeanLista {
    
    private List<SelectItem> listaNombre;
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SelectItem> getListaNombre() {
        listaNombre = new ArrayList<SelectItem>();
        listaNombre.add(new SelectItem("1", "nombre 1"));
        listaNombre.add(new SelectItem("2", "nombre 2"));
        listaNombre.add(new SelectItem("3", "nombre 3"));
        return listaNombre;
    }
}
