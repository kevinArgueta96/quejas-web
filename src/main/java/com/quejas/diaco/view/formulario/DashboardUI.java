/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.view.formulario;

import com.quejas.diaco.dto.MapaDto;
import com.quejas.diaco.svc.DeptoSvc;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author argue
 */
@Component(value = "DashboardUI")
@Scope("view")
public class DashboardUI implements Serializable {

    

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private DeptoSvc deptoSvc;
    
    private String deptoJson;
    
    private List<MapaDto> listaTotales;
    public DashboardUI() {
        // SonarFix
        super();
    }

    @PostConstruct
    public void init() {
        cargadepto();
    }
    
    /*public void cargaListas(){
        listaTotales=this.deptoSvc.ListaTotales();
    }*/
    public void cargadepto() {
        
            JSONArray Array = new JSONArray();
            listaTotales=this.deptoSvc.ListaTotales();
            for (int x = 1; x <= listaTotales.size(); x++) {
                JSONObject datosDep = new JSONObject();
                datosDep.put("nombre", listaTotales.get(x - 1).getNombreDepto());
                datosDep.put("total", listaTotales.get(x - 1).getTotal());
                Array.put(datosDep);
            }
            cargaJson(Array);
    }
    
    public void cargaJson(JSONArray Array) {
        try {
            JSONObject mainObj = new JSONObject();
            mainObj.put("Depto", Array);
            String myString = mainObj.toString();
            setDeptoJson(myString);
        } catch (JSONException e) {
            //LOG.debug("ERROR:", e);
        }
    }
    
    public List<MapaDto> getListaTotales() {
        return listaTotales;
    }

    public void setListaTotales(List<MapaDto> listaTotales) {
        this.listaTotales = listaTotales;
    }
    
    public String getDeptoJson() {
        return deptoJson;
    }

    public void setDeptoJson(String deptoJson) {
        this.deptoJson = deptoJson;
    }
}
