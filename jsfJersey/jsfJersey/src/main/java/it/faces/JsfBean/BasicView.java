package it.faces.JsfBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import it.faces.java.Persona;
import it.faces.JsfBean.PersService;
 
@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Persona> pers;
     
    @ManagedProperty("#{persService}")
    private PersService service;
 
    @PostConstruct
    public void init() {
        pers = service.createPers();        
    }
     
    public List<Persona> getPers() {
        return pers;
    }
 
    public void setService(PersService service) {
        this.service = service;
    }
    
    public void info() {
    	String etaPers = service.etaPers();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "L'età media delle persone è " + etaPers));
    }
     
   
    public String processAction() {
        return "aggiungiPersona";
    }

}