package it.test;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.test.dao.UtenteDaoImpl;
import it.test.dao.UfficioDaoImpl;
import it.test.dao.ApplicazioneDaoImpl;
import it.test.entity.Ufficio;
import it.test.entity.Utente;
import it.test.entity.Applicazione;
import it.test.entity.Dettaglioutente;

/**
 * Metodo per testare la app
 * 
 * @author Mauro Cognolato
 */
public class App {
	
    public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new  
    			  ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	//Istanzio le classi DAO
    	UtenteDaoImpl daoUte = (UtenteDaoImpl) context.getBean("utenteDao");
    	UfficioDaoImpl daoUff = (UfficioDaoImpl) context.getBean("ufficioDao");
    	ApplicazioneDaoImpl daoApp = (ApplicazioneDaoImpl) context.getBean("applicazioneDao");

    	// Definisco un oggetto Ufficio e gli assegno il valore 
    	Ufficio uff = new Ufficio();
    	uff.setNomeUfficio("Vendite");
    	daoUff.save(uff);
    	int idUff = uff.getUfficioId();
    	
    	// Istanzio e salvo gli oggetti utente e dettaglioutente
        Dettaglioutente dettUte = new Dettaglioutente( new Date(821212), "via Roma 11", "Milano", "0612345678");
        Utente ute = new Utente("Mario", "Rossi", "Amministratore");
        daoUte.saveDetUte(ute, dettUte);
        
        // Creo gli oggetti Applicazione
        Applicazione app1 = new Applicazione("SAP", "Sistema gestionale");
        daoApp.save(app1);
        Applicazione app2 = new Applicazione("GIS", "Sistemi territoriali");
        daoApp.save(app2);

        // Creo un collegamento tra il nuovo utente e l'ufficio
        daoUff.aggUffUte(ute, uff);
        
        // Creo un collegamento tra il nuovo utente e la applicazioni create
        ute.getApplicazioni().add(app1);
        ute.getApplicazioni().add(app2);
        
        // Aggiorno l'utente
        daoUte.aggUte(ute);

        // Recupero e stampo a video gli oggetti
        List<Utente> utenti = daoUte.getAll();
        String nomeUff = uff.getNomeUfficio();
        for (Utente utente : utenti) {
			System.out.println("L utente " + utente.getCognome() + " vive a " + utente.getDettaglioutente().getCitta() + " e lavora nell'ufficio " + nomeUff);
	        for (Applicazione appx : utente.getApplicazioni()) {
	        	System.out.println("Abilitato all'applicazione: " + appx.getNomeapp() + " - " + appx.getDescrizioneapp());
	        }
		}
        
        // Pulisco il Database
        // Eliminando l'oggetto uff elimino anche tutti i dettagli associati
        daoUff.deleteUfficio(idUff);
        // Elimino le applicazioni
        daoApp.deleteApplicazioni();
        
    }
    
}