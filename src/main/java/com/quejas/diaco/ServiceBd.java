/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.dao.support.DataAccessUtils;

/**
 *
 * @author argue
 */
public class ServiceBd implements Serializable {

    /**
     * Serial de la clase.
     */
    private static final long serialVersionUID = 1L;
    
   
    @PersistenceContext
    @Autowired
    @Qualifier("entityManager")
    public transient EntityManager entityManager;

    
    public ServiceBd() {
        // SonarFix
    }

    /**
     * Retorna la sesion actual con la que se esta trabajando.
     *
     * @return Session
     * @throws HibernateException Si ocurre algun error con el acceso a la BD
     */
    public Session getCurrentSession() throws PersistenceException {
        return this.entityManager.unwrap(Session.class);
    }
}
