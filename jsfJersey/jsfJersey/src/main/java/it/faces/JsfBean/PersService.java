package it.faces.JsfBean;
 
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;









import it.faces.java.*;
 
@ManagedBean(name = "persService")
@ApplicationScoped
public class PersService {


	public String MY_REST = "/rest";
	final String PERS   = "persona";
	final String ETAPERS   = "persona/etamedia";
	
	
	ClientConfig config = new DefaultClientConfig();
	Client client       = Client.create(config);
	WebResource service = client.resource(getBaseURI());
	WebResource restWS  = service.path(MY_REST);
	
    public String etaPers() {
    	String etapers = restWS.path(ETAPERS).accept(MediaType.TEXT_PLAIN).get(String.class);
    	return etapers;
    }
     
    public List<Persona> createPers() {

 
        List<Persona> people = new ArrayList();

       	Gson gson = new Gson();
       	String Json = restWS.path(PERS).accept(MediaType.APPLICATION_JSON).get(String.class);
        JsonParser parser = new JsonParser();
        JsonObject rootObejct = parser.parse(Json).getAsJsonObject();
        JsonElement personaElemento = rootObejct.get("persona");
        Type personaListaType = new TypeToken<List<Persona>>() {}.getType();
        people = gson.fromJson(personaElemento, personaListaType);

        return people;
    }
     

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/testJersey").build();
	}
}