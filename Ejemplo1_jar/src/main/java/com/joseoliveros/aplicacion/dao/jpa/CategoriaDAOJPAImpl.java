package com.joseoliveros.aplicacion.dao.jpa;

import com.joseoliveros.aplicacion.bo.Categoria;
import com.joseoliveros.aplicacion.dao.CategoriaDAO;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDAOJPAImpl extends GenericDAOJPAImpl<Categoria, Integer> implements CategoriaDAO {

}
