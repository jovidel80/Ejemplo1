package com.joseoliveros.aplicacion.dao.jpa;

import com.joseoliveros.aplicacion.dao.GenericDAO;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

    EntityManagerFactory entityManagerFactory;

    private Class<T> claseDePersistencia;

    @SuppressWarnings("unchecked")
    public GenericDAOJPAImpl() {
        this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T buscarPorClave(Id id) {
//        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
//        EntityManager manager = factoriaSession.createEntityManager();
        EntityManager manager = getEntityManagerFactory().createEntityManager();
        T objeto = null;
        try {
            objeto = manager.find(claseDePersistencia, id);
            return objeto;
        } finally {
            manager.close();
        }
    }

    @Override
    public List<T> buscarTodos() {
//        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
//        EntityManager manager = factoriaSession.createEntityManager();
        EntityManager manager = getEntityManagerFactory().createEntityManager();
        List<T> listaDeObjetos = null;
        try {
            TypedQuery<T> consulta = manager.createQuery("select o from " + claseDePersistencia.getSimpleName() + " o", claseDePersistencia);
            listaDeObjetos = consulta.getResultList();
            return listaDeObjetos;
        } finally {
            manager.close();
        }
    }

    @Override
    public void salvar(T objeto) {
//        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
//        EntityManager manager = factoriaSession.createEntityManager();
        EntityManager manager = getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = manager.getTransaction();
            tx.begin();
            manager.merge(objeto);
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    @Override
    public void borrar(T objeto) {
//        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
//        EntityManager manager = factoriaSession.createEntityManager();
        EntityManager manager = getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = manager.getTransaction();
            tx.begin();
            manager.remove(manager.merge(objeto));
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
            throw e;
        } finally {
            manager.close();
        }

    }

    @Override
    public void insertar(T objeto) {
//        EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
//        EntityManager manager = factoriaSession.createEntityManager();
        EntityManager manager = getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = manager.getTransaction();
            tx.begin();
            manager.persist(objeto);
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
