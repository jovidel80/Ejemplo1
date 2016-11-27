package com.joseoliveros.aplicacion.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class DAOAbstractFactory {

    public static DAOFactory getInstance() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();

        try {
            InputStream input = classLoader.getResourceAsStream("persistence-type.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String tipo = properties.getProperty("persistence");
        System.out.println("Tipo de persistencia = " + properties.get("persistence"));

        if (tipo.equals("Hibernate")) {
            return new DAOHibernateFactory();
        } else {
            return new DAOJPAFactory();
        }
    }
}
