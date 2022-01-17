/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco;

import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *
 * @author argue
 */
public class ViewScope  implements Scope, Serializable {
 /**
     * Serial de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Crea una nueva instancia de <code>ViewScope</code>.
     */
    public ViewScope() {
        // SonarFix
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> viewMap = facesContext.getViewRoot().getViewMap();
        Object viewScopedBean = viewMap.get(name);

        if (viewScopedBean == null) {
            viewScopedBean = objectFactory.getObject();
            viewMap.put(name, viewScopedBean);
        }

        return viewScopedBean;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Unsupported feature
    }

    @Override
    public Object remove(String name) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> viewMap = facesContext.getViewRoot().getViewMap();

        return viewMap.remove(name);
    }

    @Override
    public Object resolveContextualObject(String key) {

        // Unsupported feature
        return null;
    }

    @Override
    public String getConversationId() {

        // Unsupported feature
        return null;
    }    
}
