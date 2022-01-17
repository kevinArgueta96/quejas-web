/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.dto;
import java.io.Serializable;

/**
 * @author Kevin Argueta
 */
public class MapaDto implements Serializable {
    /**
     * Serial de la clase.
     */
    private static final long serialVersionUID = 1L; 
    
    
    private int idDepto;
    private String nombreDepto;
    private Integer total;
    private Integer totMas;
    private Integer totFem;
    private Integer totNac;
    private Integer totExt;
    private Integer totJur;
    private Integer totInd;    

     /**
     * Crea una nueva instancia de <code>MapaDto</code>.
     */
    public MapaDto() {
        // SonarFix
    }
    
     public MapaDto(int idDepto, String nombreDepto,Integer total, Integer totMas,
             Integer totFem, Integer totNac,Integer totExt,Integer totJur, 
             Integer totInd) {
        this.idDepto = idDepto;
        this.nombreDepto = nombreDepto;
        this.total=total;
        this.totMas=totMas;
        this.totFem=totFem;
        this.totNac=totNac;
        this.totExt=totExt;
        this.totJur=totJur;
        this.totInd=totInd;
    }
    
    public String getNombreDepto() {
        return nombreDepto;
    }
    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }
    
    public Integer getTotFem() {
        return totFem;
    }

    public void setTotFem(Integer totFem) {
        this.totFem = totFem;
    }

    public Integer getTotNac() {
        return totNac;
    }

    public void setTotNac(Integer totNac) {
        this.totNac = totNac;
    }

    public Integer getTotExt() {
        return totExt;
    }

    public void setTotExt(Integer totExt) {
        this.totExt = totExt;
    }

    public Integer getTotJur() {
        return totJur;
    }

    public void setTotJur(Integer totJur) {
        this.totJur = totJur;
    }

    public Integer getTotJInd() {
        return totInd;
    }

    public void setTotJInd(Integer totInd) {
        this.totInd = totInd;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public int getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }
    
    public Integer getTotMas() {
        return totMas;
    }

    public void setTotMas(Integer totMas) {
        this.totMas = totMas;
    }
}
