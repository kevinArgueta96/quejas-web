package com.quejas.diaco.svc.imp;

import com.quejas.diaco.ServiceBd;
import com.quejas.diaco.dto.MapaDto;
import com.quejas.diaco.entity.TblDepartamento;
import com.quejas.diaco.entity.TblQueja;
import com.quejas.diaco.svc.QuejaSvc;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author argue
 */

@Repository
@Transactional
public class QuejaSvcImp extends ServiceBd implements QuejaSvc,Serializable{

    @Override
    public void guardar(TblQueja queja) {
        entityManager.merge(queja);
    }

    /*@Override
    public List<TblDepartamento> obtenerListadoDepto() {
        
            List<TblDepartamento> listaDepto =this.
                    findSQL("test", TblDepartamento.class);
            return listaDepto;
    
    }*/
}
