/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc;

import com.quejas.diaco.entity.TblUser;
import java.io.Serializable;

/**
 *
 * @author argue
 */
public interface UsuarioSvc extends Serializable{
    public TblUser obtenerUsuarioPorCredenciales(TblUser User);
    
    public void guardarUsu(TblUser usuario);
    
}
