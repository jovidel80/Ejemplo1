package com.joseoliveros.aplicacion.bo.pruebas;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@SuppressWarnings("ALL")
public class Test {

    public void hacerAlgo() throws Exception {

        String s = "hola";
        Method[] methods = s.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("metodo: " + method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.toString());
            }
        }
    }
}
