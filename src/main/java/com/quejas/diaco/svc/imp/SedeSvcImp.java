/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc.imp;

import com.quejas.diaco.ServiceBd;
import com.quejas.diaco.entity.TblSede;
import com.quejas.diaco.svc.SedeSvc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author argue
 */

@Repository
@Transactional
public class SedeSvcImp  extends ServiceBd implements SedeSvc, Serializable  {

    @Override
    public List<SelectItem> obtenerLitadoDepto() {
        List<TblSede> listasede;
        List<SelectItem> lista = new ArrayList<>();
        String query = "FROM TblSede";
        listasede = entityManager.createQuery(query).getResultList();
        
        listasede.forEach(item
                    -> lista.add(new SelectItem(item.getIdSede(),
                            item.getNombreSede()))
            );
        return lista;
    }
    
}
