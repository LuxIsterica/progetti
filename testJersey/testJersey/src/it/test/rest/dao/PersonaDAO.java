package it.test.rest.dao;

import it.test.rest.pojo.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PersonaDAO {
	
	public List<Persona> PersonaDAO() {
		
		List<Persona> personaList = new ArrayList<Persona>();
		Persona persona = new Persona(1, "Mauro", "Rossi", 40, "02/456327819", "mrossi@email.it");
		personaList.add(persona);
		
		persona = new Persona(2, "Luca", "Bianchi", 45, "02/918273645", "lbianchi@email.it");
		personaList.add(persona);
		
		persona = new Persona(3, "Franco", "Neri", 32, "02/987123546", "fneri@email.it");
		personaList.add(persona); 
		
		persona = new Persona(4, "Paolo", "Verdi", 35, "02/129834765", "pverdi@email.it");
		personaList.add(persona); 	
		
		return personaList;
		
	}

	
}
