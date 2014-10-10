package it.faces.JsfBean;
 
import java.net.URI;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

 
@ManagedBean(name="dtMaskView")
@ViewScoped
public class MaskView {
     
    private String id;
    private String nome;
    private String cognome;
    private String eta;
    private String telefono;
    private String email;
    
	final String MY_REST = "http://localhost:8080/RESTJerseyWS/rest";
	final String PERS   = "persona";
	
	ClientConfig config = new DefaultClientConfig();
	Client client       = Client.create(config);
	WebResource service = client.resource("");
	WebResource restWS  = service.path(MY_REST);
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
/*
	public ClientConfig getConfig() {
		return config;
	}

	public void setConfig(ClientConfig config) {
		this.config = config;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public WebResource getService() {
		return service;
	}

	public void setService(WebResource service) {
		this.service = service;
	}

	public WebResource getRestWS() {
		return restWS;
	}

	public void setRestWS(WebResource restWS) {
		this.restWS = restWS;
	}

	public String getMY_REST() {
		return MY_REST;
	}

	public String getUSERS() {
		return USERS;
	} */

	public String processAction() {
		Form form = new Form();
		form.add("id", id);
		form.add("nome", nome);
		form.add("cognome", cognome);
		form.add("eta", eta);
		form.add("telefono", telefono);
		form.add("email", email);
		System.out.println(id + "--" + nome + "--" + cognome + "--" + eta + "--" + telefono + "--" + email);
		ClientResponse response = restWS.path(PERS).type(MediaType.APPLICATION_FORM_URLENCODED)
								   .post(ClientResponse.class, form);
        return "index";
    }
}