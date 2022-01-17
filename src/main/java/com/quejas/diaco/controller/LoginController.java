/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.controller;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.quejas.diaco.dto.testDTO;
import com.quejas.diaco.svc.imp.TestSvcImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Esta clase define un controlador de Spring (MVC) para el manejo de las
 * peticiones HTTP.
 *
 */
@Controller
public class LoginController implements Serializable {

    /**
     * Serial de la clase.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Permite generar mensajes de log, estos mensajes muestran el resultado de
     * las operaciones realizadas por la clase.
     */
    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    /**
     * Crea una nueva instancia de <code>LoginController</code>.
     */
    @Autowired
    private TestSvcImp testSvcImp;
    public LoginController() {
        // SonarFix
        LOGGER.info("Constructor: LoginController");
    }

    /**
     * Metodo que sirve para ejemplificar un Mapeo y el retorno de una cadena
     * que implementa una llamada hacia un template o vista.
     *
     * @return String con el nombre del template o vista para manejar.
     */
    @GetMapping({"/"})
    public String loginCheck() {
        LOGGER.debug("Peticion: loginCheck");
        LOGGER.debug("redirect:/login");
        //return "redirect:http://localhost:18080/login.xhtml";
        return "redirect:http://localhost:8080/quejas-web/queja.xhtml";
    }
    
    /*@GetMapping("/hola")
    @ResponseBody
    public String login() {
        
        return "hola";
 
    }*/
    
}
