package com.joseoliveros.aplicacion.bo.pruebas;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.bo.Libro;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Prueba {

    private static final Logger log = Logger.getLogger(Prueba.class.getPackage().getName());

    public static void main(String[] args) throws IOException {

        String texto = "";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("libros.txt");
        Reader reader = new InputStreamReader(is);
        BufferedReader lector = new BufferedReader(reader);
        List<Libro> lista = new ArrayList<>();
        Libro libro = null;
        Categoria categoria = null;
        while ((texto = lector.readLine()) != null) {
            String[] datos = texto.split(",");
            categoria = new Categoria((Integer.parseInt(datos[2])), datos[3]);
            libro = new Libro(datos[0], datos[1], categoria);
            lista.add(libro);
        }
        for (Libro libro1 : lista) {
            System.out.println(libro1);
        }
    }
}
