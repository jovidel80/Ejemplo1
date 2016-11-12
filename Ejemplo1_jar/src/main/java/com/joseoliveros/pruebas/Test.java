package com.joseoliveros.pruebas;

import com.joseoliveros.Libro;

import java.lang.reflect.Method;

public class Test<T> {

    public void hacerAlgo() throws Exception {

        T obj = (T) Class.forName(Libro.class.getName()).newInstance();
        Method[] metodos = obj.getClass().getDeclaredMethods();
        for (Method method : metodos) {
            System.out.println(method.getName());
        }
    }
}
