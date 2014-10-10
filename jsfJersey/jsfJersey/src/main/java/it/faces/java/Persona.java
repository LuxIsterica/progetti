package it.faces.java;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class Persona implements Serializable {

	private String id;
	
	private String nome;

	private String cognome;
	
	private String eta;
	
	private String telefono;	
	
	private String email;
	
//	public Persona() {}
	
	public Persona(String Id, String Nome, String Cognome, String Eta, String Telefono, String Email) {
		this.id = Id;
		this.nome = Nome;
		this.cognome = Cognome;
		this.eta = Eta;
		this.telefono = Telefono;		
		this.email = Email;
	
	}

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

}
