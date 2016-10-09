/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author wais
 */
public abstract class AbstractDao<PK extends Serializable, T> {
    
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
    
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    protected Session getSession(){
        return this.getAppropriateSession();
    }
    
    public void releaseSession(){
        this.getAppropriateSession().close();
    }
    
    public Session getAppropriateSessionNew() {
        return sessionFactory.openSession();
    }
    
    public Session getAppropriateSession() {
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    public void persist(T entity) {
        getSession().persist(entity);
    }
    
    public void update(T entity) {
        getSession().update(entity);
    }
    
    public Object merge(T entity) {
        return getSession().merge(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
     
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
 
}
