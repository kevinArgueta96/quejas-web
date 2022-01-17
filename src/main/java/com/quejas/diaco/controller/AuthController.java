/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.controller;

import com.quejas.diaco.entity.TblUser;
import com.quejas.diaco.svc.UsuarioSvc;
import com.quejas.diaco.utils.JWTUtil;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author argue
 */
@RestController
public class AuthController implements Serializable {

    @Autowired
    private UsuarioSvc usuarioSvc;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Serial de la clase.
     */
    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "/api/appLogin", method = RequestMethod.POST)
    public String login(@RequestBody TblUser Usuario) {

        TblUser usuarioLogueado = usuarioSvc.obtenerUsuarioPorCredenciales(Usuario);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getIdUsuario()), usuarioLogueado.getUsername());
            return tokenJwt;
        }else{
    return "FAIL";
    }
}

/*@GetMapping("/hola")
        @ResponseBody
        public String hola() {
        
        return "hola";
 
    }*/
    
}
