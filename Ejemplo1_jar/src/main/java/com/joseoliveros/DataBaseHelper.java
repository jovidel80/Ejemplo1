package com.joseoliveros;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper<T> {

    private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/arquitecturajava";
    private final String USUARIO = "root";
    private final String CLAVE = "root";

    public int modificarResgistro(String consultaSQL) {
        Connection conexion = null;
        Statement sentencia = null;
        int filasAfectadas = 0;

        try {
            Class.forName(DRIVER);
            log.debug("Cargando driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(consultaSQL);
        } catch (ClassNotFoundException e) {
            log.error("Error de acceso al driver " + e.getMessage());
            throw new DataBaseException("Error de SQL: ", e);
        } catch (SQLException e) {
            log.error("Error de SQL " + e.getMessage());
            throw new DataBaseException("Error de SQL", e);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    log.error("Error cerrando el statement: " + e.getMessage());
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    log.error("Error cerrando la conexion: " + e.getMessage());
                }
            }
        }
        return filasAfectadas;
    }

    public List<T> seleccionarRegistros(String consultaSQL, Class clase) throws DataBaseException {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet filas;
        List<T> listaDeObjetos = new ArrayList<T>();

        try {
            Class.forName(DRIVER);
            log.debug("Cargando driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            sentencia = conexion.createStatement();
            filas = sentencia.executeQuery(consultaSQL);
            while (filas.next()) {
                T objeto = (T) Class.forName(clase.getName()).newInstance();
                Method[] metodos = objeto.getClass().getDeclaredMethods();
                for (int i=0;i<metodos.length;i++) {
                    if (metodos[i].getName().startsWith("set") ) {
                        metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
                    }
                    if (objeto.getClass().getName().equals("java.lang.String")) {
                        objeto=(T)filas.getString(1);
                    } }
                listaDeObjetos.add(objeto);
            }
        } catch (Exception e) {
            log.error("Error al seleccionar registros " + e.getMessage());
            e.printStackTrace();
            throw new DataBaseException("Error al seleccionar registros");
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    log.error("Error de SQL " + e.getMessage());
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    log.error("Error de SQL " + e.getMessage());
                }
            }
        }
        return listaDeObjetos;
    }
}
