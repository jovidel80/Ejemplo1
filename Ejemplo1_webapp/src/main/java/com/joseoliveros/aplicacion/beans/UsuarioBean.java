package com.joseoliveros.aplicacion.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
