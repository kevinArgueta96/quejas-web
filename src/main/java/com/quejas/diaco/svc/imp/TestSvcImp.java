/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc.imp;

import com.quejas.diaco.ServiceBd;
import com.quejas.diaco.dto.testDTO;
import com.quejas.diaco.entity.Test;
import java.io.Serializable;
import java.util.List;
import com.quejas.diaco.svc.TestSvc;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


/**
 *
 * @author argue
 */
@Repository
@Transactional
public class TestSvcImp extends ServiceBd implements TestSvc, Serializable{
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<testDTO> find() {
       String query = "FROM Test";
       return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(int id) {
        Test t = entityManager.find(Test.class,id);
        entityManager.remove(t);
    }

    @Override
    public void guardar(Test x) {
        entityManager.merge(x);
    }
}
