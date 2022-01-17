/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc;

/**
 *
 * @author argue
 */
import com.quejas.diaco.dto.DeptoDto;
import com.quejas.diaco.dto.MapaDto;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;
import org.springframework.data.jpa.repository.Query;

public interface DeptoSvc extends Serializable {

    /**
     * Metodo que sirve para consultar la informacion del Ente pendiente de
     * inscribir.
     *
     * @return DTO con los detalles del Ente pendientes de inscribir.
     */
    List<DeptoDto> find();

    public List<SelectItem> obtenerLitadoDepto();
    //public List<SelectItem> obtenerLitadoMunById(String pCodigo);
   @Query (nativeQuery = true)
    public List<MapaDto> ListaTotales();
}
