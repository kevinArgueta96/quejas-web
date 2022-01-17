/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.view.formulario;

//import com.quejas.diaco.models.testDTO;
import com.quejas.diaco.dto.MapaDto;
import com.quejas.diaco.entity.TblConsumidor;
import com.quejas.diaco.entity.TblDepartamento;
import com.quejas.diaco.entity.TblMunicipio;
import com.quejas.diaco.entity.TblQueja;
import com.quejas.diaco.entity.TblSede;
import com.quejas.diaco.entity.TblUser;
import com.quejas.diaco.svc.ConsumidorSvc;
import com.quejas.diaco.svc.DeptoSvc;
import com.quejas.diaco.svc.MunicipioSvc;
import com.quejas.diaco.svc.QuejaSvc;
import com.quejas.diaco.svc.SedeSvc;
import com.quejas.diaco.svc.UsuarioSvc;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
//import com.quejas.diaco.svc.TestSvc;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//import com.quejas.diaco.svc.TestSvc;

/**
 *
 * @author argue
 */
@Component(value = "FormularioUI")
@Scope("view")
public class FormularioUI implements Serializable {

    @Autowired
    private DeptoSvc deptoSvc;

    @Autowired
    private SedeSvc sedeSvc;

    @Autowired
    private MunicipioSvc municipioSvc;

    @Autowired
    private ConsumidorSvc consumidorSvc;

    @Autowired
    private QuejaSvc quejaSvc;

    /**
     * Serial de la clase.
     */
    private static final long serialVersionUID = 1L;
    /*
    * Almacena los pasos del panel
     */
    private int panel;
    /*
    *VARIABLES
     */
    private String nombreNegocio;
    private String nitNegocio;
    private String direecionNego;
    private String noFactura;
    private Date fechaQueja;
    private String solicitudQueja;
    private String telefono;
    private String correo;
    private int iddeptoQ;
    private int idmunQ;
    private int iddeptoC;
    private int idmunC;
    private int idSede;
    private int idConsumidor;
    private List<SelectItem> listaD;
    private List<SelectItem> listaDN;
    private List<SelectItem> listaSede;
    private List<SelectItem> listaMun;
    private List<SelectItem> listaMunN;
    private String genero;
    private String consumidor;
    private String nacionalidad;
    private String queja;
    private String factura;

    public FormularioUI() {
        // SonarFix
        super();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @PostConstruct
    public void init() {
        this.iniciarCaptcha();
        cargaLista();
        
        
    }

    /**
     * Metodo luego de validar el captcha. Es posible acceder a este metodo
     * solamente cuando la validacion del captcha es correcta.
     */
    protected void iniciarCaptcha() {
        this.cargarPanel(0);
    }

    /**
     * Metodo luego de validar el captcha. Es posible acceder a este metodo
     * solamente cuando la validacion del captcha es correcta.
     */
    public void validarCaptcha() {
        this.cargarPanel(1);
    }

    /**
     * Metodo para cargar LISTAS
     */
    protected void cargaLista() {
        listaD = this.deptoSvc.obtenerLitadoDepto();
        listaDN = this.deptoSvc.obtenerLitadoDepto();
        listaSede = this.sedeSvc.obtenerLitadoDepto();
    }

    /**
     * Metodo para cargar lista depto
     */
    /*
     *Metodo que captura y envia los datos del formulario
     */
    public void envioSolicitud() {
        int idUConsumidor = InsertConsumidor();
        InsertQueja(idUConsumidor);
        this.cargarPanel(2);
    }

    public int InsertConsumidor() {
        TblConsumidor cosu = new TblConsumidor();
        TblDepartamento a = new TblDepartamento();
        TblMunicipio b = new TblMunicipio();
        cosu.setTipoConsumidor(getConsumidor());
        cosu.setGenero(getGenero().toUpperCase());
        cosu.setNacionalidad(getNacionalidad().toUpperCase());
        a.setIdDepto(getIddeptoC());
        b.setIdMun(getIdmunC());
        cosu.setTblDepartamento(a);
        cosu.setTblMunicipio(b);
        consumidorSvc.insertConsu(cosu);
        return consumidorSvc.LastId();
    }

    public void InsertQueja(int idUConsumidor) {
        TblConsumidor cosu = new TblConsumidor();
        TblDepartamento a = new TblDepartamento();
        TblMunicipio b = new TblMunicipio();
        TblSede sede = new TblSede();
        TblQueja queja = new TblQueja();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        
        queja.setNombreNegocio(getNombreNegocio());
        queja.setNitNegocio(getNitNegocio());
        queja.setDireccion(getDireecionNego());
        queja.setNoFactura(getNoFactura());
        queja.setFechaFactura(getFechaQueja());
        queja.setFechaCreacion((date));
        queja.setSolicitudQueja(getSolicitudQueja());
        queja.setTelefono(getTelefono());
        queja.setCorreo(getCorreo());
        a.setIdDepto(getIddeptoQ());
        b.setIdMun(getIdmunQ());
        sede.setIdSede(getIdSede());
        cosu.setIdConsumidor(idUConsumidor);
        queja.setTblMunicipio(b);
        queja.setTblDepartamento(a);
        queja.setTblSede(sede);
        queja.setTblConsumidor(cosu);
        quejaSvc.guardar(queja);
    }

    public void ValidarSede(FacesContext pContext,
            UIComponent pValidate, Object pValue) {
        int valor;

        if (pValue != null) {
            valor = (int) pValue;
            this.setIdSede(valor);
        }
    }

    public void validarDepartamento(FacesContext pContext,
            UIComponent pValidate, Object pValue) {
        int valor;

        if (pValue != null) {
            valor = (int) pValue;
            this.setIddeptoC(valor);
            listaMun = this.municipioSvc.obtenerLitadoMunId(valor);
        }
    }

    public void validarDepartamentoN(FacesContext pContext,
            UIComponent pValidate, Object pValue) {
        int valor;

        if (pValue != null) {
            valor = (int) pValue;
            this.setIddeptoQ(valor);
            listaMunN = this.municipioSvc.obtenerLitadoMunId(valor);
        }
    }

    /**
     * Metodo que sirve para cargar un panel determinado. El panel se pinta de
     * nuevo.
     *
     * @param codigo Codigo del panel que se desea cargar.
     */
    public void cargarPanel(int codigo) {
        this.panel = codigo;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getQueja() {
        return queja;
    }

    public void setQueja(String queja) {
        this.queja = queja;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getPanel() {
        return panel;
    }

    public void setPanel(int panel) {
        this.panel = panel;
    }

    public String getNitNegocio() {
        return nitNegocio;
    }

    public void setNitNegocio(String nitNegocio) {
        this.nitNegocio = nitNegocio;
    }

    public String getDireecionNego() {
        return direecionNego;
    }

    public void setDireecionNego(String direecionNego) {
        this.direecionNego = direecionNego;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public Date getFechaQueja() {
        return fechaQueja;
    }

    public void setFechaQueja(Date fechaQueja) {
        this.fechaQueja = fechaQueja;
    }

    public String getSolicitudQueja() {
        return solicitudQueja;
    }

    public void setSolicitudQueja(String solicitudQueja) {
        this.solicitudQueja = solicitudQueja;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIddeptoQ() {
        return iddeptoQ;
    }

    public void setIddeptoQ(int iddeptoQ) {
        this.iddeptoQ = iddeptoQ;
    }

    public int getIdmunQ() {
        return idmunQ;
    }

    public void setIdmunQ(int idmunQ) {
        this.idmunQ = idmunQ;
    }

    public int getIddeptoC() {
        return iddeptoC;
    }

    public void setIddeptoC(int iddeptoC) {
        this.iddeptoC = iddeptoC;
    }

    public int getIdmunC() {
        return idmunC;
    }

    public void setIdmunC(int idmunC) {
        this.idmunC = idmunC;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public int getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public String getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(String consumidor) {
        this.consumidor = consumidor;
    }

    public List<SelectItem> getListaD() {
        return listaD;
    }

    public void setListaD(List<SelectItem> listaD) {
        this.listaD = listaD;
    }

    public List<SelectItem> getListaDN() {
        return listaDN;
    }

    public void setListaDN(List<SelectItem> listaDN) {
        this.listaDN = listaDN;
    }

    public List<SelectItem> getListaMunN() {
        return listaMunN;
    }

    public void setListaMunN(List<SelectItem> listaMunN) {
        this.listaMunN = listaMunN;
    }

    public List<SelectItem> getListaMun() {
        return listaMun;
    }

    public void setListaMun(List<SelectItem> listaMun) {
        this.listaMun = listaMun;
    }

    public List<SelectItem> getListaSede() {
        return listaSede;
    }

    public void setListaSede(List<SelectItem> listaSede) {
        this.listaSede = listaSede;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
