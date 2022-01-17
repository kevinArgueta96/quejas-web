/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc.imp;

import com.quejas.diaco.ServiceBd;
import com.quejas.diaco.dto.DeptoDto;
import com.quejas.diaco.dto.MapaDto;
import com.quejas.diaco.svc.DeptoSvc;
import com.quejas.diaco.entity.TblDepartamento;
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
public class DeptoSvcImp extends ServiceBd implements DeptoSvc, Serializable {

    @Override
    public List<DeptoDto> find() {
        String query = "FROM TblDepartamento";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<SelectItem> obtenerLitadoDepto() {
        List<TblDepartamento> listadepto;
        List<SelectItem> lista = new ArrayList<>();
        String query = "FROM TblDepartamento";
        listadepto = entityManager.createQuery(query).getResultList();
        
        listadepto.forEach(item
                    -> lista.add(new SelectItem(item.getIdDepto(),
                            item.getNombre()))
            );
        return lista;
    }

    /*@Override
    public List<SelectItem> obtenerLitadoMunById(String pCodigo) {
        String query = "FROM TblDepartamento where ";
    }*/

    @Override
    public List<MapaDto> ListaTotales() {
        List<MapaDto> lista = entityManager.createNamedQuery("buscarTotales").getResultList();
        return lista;
    }

}
