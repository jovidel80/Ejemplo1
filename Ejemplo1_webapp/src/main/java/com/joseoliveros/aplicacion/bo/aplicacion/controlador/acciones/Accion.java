package com.joseoliveros.aplicacion.bo.aplicacion.controlador.acciones;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {

    private static final Logger log = Logger.getLogger(Accion.class.getPackage().getName());

    public static Accion getAccion(String tipo) {
        log.info("Ejecutando getAccion de tipo: " + tipo);
        Accion accion = null;

            try {
                accion = (Accion) Class.forName(getPackage() + "." + tipo + "Accion").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return accion;
    }

    private static String getPackage() {
        return Accion.class.getPackage().getName();
    }

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
}
