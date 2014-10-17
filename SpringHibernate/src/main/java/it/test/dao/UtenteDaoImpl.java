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
	
	public void deleteUtente(Integer id) {
		em.remove(getUtente(id));
	}
	
	public Utente getUtente(Integer id) {
		return em.find(Utente.class, id);
	}	
	
	public void aggUteApp(Utente ute, Applicazione app) {
        
        em.merge(ute);
	}
	
	public List<Utente>getAll() {
		return em.createQuery("SELECT p FROM Utente p", Utente.class).getResultList();
	}

	public void saveDetUte(Utente ute, Dettaglioutente dettUte) {	
    ute.setDettaglioutente(dettUte);
    dettUte.setUtente(ute);
    em.persist(ute);
	em.flush();
	// riallinea l'entità ai valori del DB
	em.refresh(ute);
	}
	
}
