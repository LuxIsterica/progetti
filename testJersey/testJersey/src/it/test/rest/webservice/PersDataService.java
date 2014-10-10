package it.test.rest.webservice;

import it.test.rest.dao.PersonaDAO;
import it.test.rest.pojo.Persona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 * Questo WebService mi permette di gestire una ipotetica anagrafica di persone
 */

@Path("/persona")
public class PersDataService {

	/*
	 * Questa annotation @Context mi permette di caricare all'interno della classe
	 * oggetti esterni come ad esempio: ServletContext, Request, Response, UriInfo
	 	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
*/

	/*
	 * Questi due metodi che seguono restituiscono la lista di persone
	 * in formato testo, tipicamente per il browser o in formato
	 * XML/JSON per chiamate applicative
	 */
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Persona> getPeopleBrowser() {
		List<Persona> people = new ArrayList<Persona>();
		PersonaDAO PersDao = new PersonaDAO(); 
		people.addAll(PersDao.PersonaDAO());
		return people; 
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Persona> getPeople() {
		List<Persona> people = new ArrayList<Persona>();
		PersonaDAO PersDao = new PersonaDAO(); 
		people.addAll(PersDao.PersonaDAO());
		return people; 
	}
		
	/*
	 * Questo metodo calcola l'età media
	*/
	
	@GET
	@Path("etamedia")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEta() {
		List<Persona> people = new ArrayList<Persona>();
		PersonaDAO perdao = new PersonaDAO();
		people.addAll(perdao.PersonaDAO());
		int toteta = 0;
		for (Persona pers : people) {
			toteta += pers.getEta();
		}
		int etamedia = toteta / people.size();
		return Integer.toString(etamedia);
	}
	
	/*
	 * Questo metodo consente il salvataggio di nuovi record
	 * a fronte di una chiamata POST attraverso il form di inserimento
	 * dati
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newUser(
			@FormParam("id") String id,
			@FormParam("nome") String nome,
			@FormParam("cognome") String cognome,
			@FormParam("eta") String eta,
			@FormParam("telefono") String telefono,
			@FormParam("email") String email,
			@Context HttpServletResponse servletResponse
	) throws IOException {
		Persona persona = new Persona(new Integer(id),nome,cognome, Integer.parseInt(eta),telefono,email);
		
		// Eseguo il caricamento su Database....
		
	}
		


}
