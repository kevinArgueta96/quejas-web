/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc;

import com.quejas.diaco.entity.TblQueja;
import java.io.Serializable;

/**
 *
 * @author argue
 */
public interface QuejaSvc extends Serializable{
     public void guardar(TblQueja queja);
    
}
