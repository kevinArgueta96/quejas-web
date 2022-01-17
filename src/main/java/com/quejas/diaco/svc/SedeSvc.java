/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author argue
 */
public interface SedeSvc  extends Serializable{
    
    public List<SelectItem> obtenerLitadoDepto();
    
}
