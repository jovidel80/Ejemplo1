package com.joseoliveros.aplicacion.dao.jpa;

import com.joseoliveros.aplicacion.dao.GenericDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class GenericDAOJPAImpl<T, Id extends Serializable>  implements GenericDAO<T, Id> {

    private static final Logger log = Logger.getLogger(GenericDAOJPAImpl.class.getPackage().getName());


    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private Class<T> claseDePersistencia;

    @SuppressWarnings("unchecked")
    public GenericDAOJPAImpl() {
        this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @Transactional(readOnly = true)
    public T buscarPorClave(Id id) {
        log.info("Buscando por id = " + id + ", del tipo " + claseDePersistencia.getSimpleName());
        return getEntityManager().find(claseDePersistencia, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> buscarTodos() {
        log.info("Buscando todos del tipo " + claseDePersistencia.getSimpleName());
        List<T> listaDeObjetos = null;
        TypedQuery<T> consulta = entityManager.createQuery("select o from " + claseDePersistencia.getSimpleName()
                + " o", claseDePersistencia);
        listaDeObjetos = consulta.getResultList();
        return listaDeObjetos;
    }

    @Override
    @Transactional
    public void salvar(T objeto) {
        log.info("Salvando objeto del tipo " + claseDePersistencia.getSimpleName());
        getEntityManager().merge(objeto);
    }

    @Override
    @Transactional
    public void borrar(T objeto) {
        log.info("Borrando objeto del tipo " + claseDePersistencia.getSimpleName());
        getEntityManager().remove(getEntityManager().merge(objeto));
    }

    @Override
    @Transactional
    public void insertar(T objeto) {
        log.info("Insertando objeto del tipo " + claseDePersistencia.getSimpleName());
        getEntityManager().persist(objeto);
    }
}
