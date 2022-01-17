/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc;

import com.quejas.diaco.dto.testDTO;
import com.quejas.diaco.entity.Test;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author argue
 */
public interface TestSvc extends Serializable{
    
     /**
     * Metodo que sirve para consultar la informacion del Ente pendiente de inscribir.
     *
     * @return DTO con los detalles del Ente pendientes de inscribir.
     */
    List<testDTO> find();
    
    void eliminar (int id);
    
    void guardar (Test x);
    
}
