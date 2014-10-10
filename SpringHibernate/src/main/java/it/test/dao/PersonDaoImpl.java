package it.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import it.test.entity.*;


/**
 * Implementazione DAO
 *  
 * @author Mauro Cognolato
 */
@Transactional
public class PersonDaoImpl {

	@PersistenceContext
	private EntityManager em;
	
	
	public int save(Person person) {
		em.persist(person);
		return person.getId();
	}
	
	public List<Person>getAll() {
		return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
	}
	
}
