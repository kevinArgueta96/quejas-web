/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc.imp;

import com.quejas.diaco.ServiceBd;
import com.quejas.diaco.dto.ConsumidorDto;
import com.quejas.diaco.entity.TblConsumidor;
import com.quejas.diaco.svc.ConsumidorSvc;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author argue
 */
@Repository
@Transactional
public class ConsumidorSvcImp  extends ServiceBd implements ConsumidorSvc,Serializable{

    @Override
    public void insertConsu(TblConsumidor consu) {
         entityManager.merge(consu);
    }

    @Override
    public int LastId() {
        String query = "FROM TblConsumidor ORDER BY id_consumidor DESC ";
        List<TblConsumidor> listaConsumidor;
        listaConsumidor = entityManager.createQuery(query).getResultList();
        return listaConsumidor.get(0).getIdConsumidor();
    }
    
}
