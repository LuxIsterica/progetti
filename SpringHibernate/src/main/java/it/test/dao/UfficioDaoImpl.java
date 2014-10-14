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
public class UfficioDaoImpl {

	@PersistenceContext
	private EntityManager em;
	
	
	public int save(Ufficio ufficio) {
		em.persist(ufficio);
		return ufficio.getUfficioId();
	}
	
	public void deleteUfficio(Integer id) {
		em.remove(getUfficio(id));
	}

	public Ufficio getUfficio(Integer id) {
		return em.find(Ufficio.class, id);
	}

	public List<Ufficio>getAll() {
		return em.createQuery("SELECT p FROM Ufficio p", Ufficio.class).getResultList();
	}
	
}
