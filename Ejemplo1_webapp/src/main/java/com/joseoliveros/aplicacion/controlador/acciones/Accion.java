package com.joseoliveros.aplicacion.controlador.acciones;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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

    public Object getBean(String nombre, HttpServletRequest request) {
        System.out.println("ServletContext = " + request.getSession().getServletContext());
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        return context.getBean(nombre);
    }
}
