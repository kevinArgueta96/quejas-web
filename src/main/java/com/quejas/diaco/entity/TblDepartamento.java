package com.quejas.diaco.entity;
// Generated 20/09/2021 12:21:51 AM by Hibernate Tools 4.3.1

import com.quejas.diaco.dto.MapaDto;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

/**
 * TblDepartamento generated by hbm2java
 */
@Entity
@NamedQuery(name = "buscar", query = "from TblDepartamento ")
@NamedNativeQuery(name = "buscarTotales",
        //query = "Select  dep.id_depto as idDepto, dep.nombre as nombreDepto \n" +
        //"from tbl_departamento dep",
        query = "Select  dep.id_depto as idDepto, dep.nombre as nombreDepto,count(que.id_depto) as total,count(case when con.genero='MASCULINO' then 'M' end) as totMas,"
                + " count(case when con.genero='FEMENINO' then 'F' end) as 'totFem', "+
                " count(case when con.nacionalidad ='NACIONAL' then 'N' end) as 'totNac', "
                + " count(case when con.nacionalidad ='EXTRANJERO' then 'N' end) as 'totExt',"
                + " count(case when con.tipo_consumidor ='Juridico' then 'N' end) as 'totJur', "
                + " count(case when con.tipo_consumidor ='Individual' then 'N' end) as 'totInd' "
        + "from tbl_departamento dep left join tbl_queja que left join tbl_consumidor con on con.id_consumidor=que.id_consumidor\n"
        + "on que.id_depto=dep.id_depto group by dep.nombre order BY dep.nombre",
        resultSetMapping = "Mapping.MapaDto")
@SqlResultSetMapping(name = "Mapping.MapaDto",
        classes = @ConstructorResult(targetClass = MapaDto.class,
                columns = {
                    @ColumnResult(name = "idDepto"),
                    @ColumnResult(name = "nombreDepto"),
                    @ColumnResult(name = "total" , type = Integer.class),
                    @ColumnResult(name = "totMas" , type = Integer.class),
                @ColumnResult(name = "totFem" , type = Integer.class),
                @ColumnResult(name = "totNac" , type = Integer.class),
                @ColumnResult(name = "totExt" , type = Integer.class),
                @ColumnResult(name = "totJur" , type = Integer.class),
                @ColumnResult(name = "totInd" , type = Integer.class)}))
/*@NamedNativeQueries({
    @NamedNativeQuery(
            name = "test",
            /*query = "Select  dep.id_depto, dep.nombre \n" +
                "from tbl_departamento dep"+
                "left join tbl_queja que\n" +
                "on que.id_depto=dep.id_depto",*/
 /*query = "Select  dep.id_depto, dep.nombre,count(que.id_depto) TOTAL,count(case when con.genero='MASCULINO' then 'M' end) as 'MASCULINO' \n"
            + "from tbl_departamento dep left join tbl_queja que left join tbl_consumidor con on con.id_consumidor=que.id_consumidor\n" +
"on que.id_depto=dep.id_depto group by dep.nombre order BY dep.nombre",
            //resultClass = MapaDto.class
            resultClass = TblDepartamento.class
    )
        
})*/
@Table(name = "tbl_departamento",
        catalog = "diacobd"
)
public class TblDepartamento implements java.io.Serializable {

    private int idDepto;
    private String nombre;
    private Set<TblQueja> tblQuejas = new HashSet<TblQueja>(0);
    private Set<TblConsumidor> tblConsumidors = new HashSet<TblConsumidor>(0);
    private Set<TblMunicipio> tblMunicipios = new HashSet<TblMunicipio>(0);

    public TblDepartamento() {
    }

    public TblDepartamento(int idDepto) {
        this.idDepto = idDepto;
    }

    public TblDepartamento(int idDepto, String nombre, Set<TblQueja> tblQuejas, Set<TblConsumidor> tblConsumidors, Set<TblMunicipio> tblMunicipios) {
        this.idDepto = idDepto;
        this.nombre = nombre;
        this.tblQuejas = tblQuejas;
        this.tblConsumidors = tblConsumidors;
        this.tblMunicipios = tblMunicipios;
    }

    @Id

    @Column(name = "id_depto", unique = true, nullable = false)
    public int getIdDepto() {
        return this.idDepto;
    }

    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }

    @Column(name = "nombre", length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblDepartamento")
    public Set<TblQueja> getTblQuejas() {
        return this.tblQuejas;
    }

    public void setTblQuejas(Set<TblQueja> tblQuejas) {
        this.tblQuejas = tblQuejas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblDepartamento")
    public Set<TblConsumidor> getTblConsumidors() {
        return this.tblConsumidors;
    }

    public void setTblConsumidors(Set<TblConsumidor> tblConsumidors) {
        this.tblConsumidors = tblConsumidors;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblDepartamento")
    public Set<TblMunicipio> getTblMunicipios() {
        return this.tblMunicipios;
    }

    public void setTblMunicipios(Set<TblMunicipio> tblMunicipios) {
        this.tblMunicipios = tblMunicipios;
    }

}