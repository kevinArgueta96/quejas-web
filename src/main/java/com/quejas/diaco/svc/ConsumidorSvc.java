/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc;

import com.quejas.diaco.entity.TblConsumidor;
import java.io.Serializable;

/**
 *
 * @author argue
 */
public interface ConsumidorSvc extends Serializable{
    
    public void insertConsu(TblConsumidor consu);
    public int LastId();
    
}
