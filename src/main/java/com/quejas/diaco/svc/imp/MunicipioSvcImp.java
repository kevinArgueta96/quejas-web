/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc.imp;

import com.quejas.diaco.ServiceBd;
import com.quejas.diaco.dto.DeptoDto;
import com.quejas.diaco.entity.TblMunicipio;
import com.quejas.diaco.svc.MunicipioSvc;
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
public class MunicipioSvcImp extends ServiceBd implements MunicipioSvc , Serializable{
    
    @Override
    public List<SelectItem> obtenerLitadoMunId(int pCodigo) {
        List<SelectItem> lista = new ArrayList<>();
        
        String query = "FROM TblMunicipio WHERE id_depto = :id_depto";
        List<TblMunicipio> listaDe = entityManager.createQuery(query).
                setParameter("id_depto", pCodigo).getResultList();
         listaDe.forEach(item
                    -> lista.add(new SelectItem(item.getIdMun(),
                            item.getNombre()))
            );
        return lista;
    }
    
}
