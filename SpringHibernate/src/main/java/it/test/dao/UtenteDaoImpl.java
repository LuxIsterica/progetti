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
public class UtenteDaoImpl {

	@PersistenceContext
	private EntityManager em;
	
	
	public int save(Utente utente) {
		em.persist(utente);
		return utente.getuserId();
	}
	
	public List<Utente>getAll() {
		return em.createQuery("SELECT p FROM Utente p", Utente.class).getResultList();
	}

	public void saveDetUte(Utente ute, Dettaglioutente dettUte) {
		ute.setDettaglioutente(dettUte);
		dettUte.setUtente(ute);
		em.persist(ute);

	}
	
}
