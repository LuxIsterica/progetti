package it.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.test.dao.UtenteDaoImpl;
import it.test.entity.Utente;

/**
 * Metodo per testare la app
 * 
 * @author Mauro Cognolato
 */
public class App {
	
    public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new  
    			  ClassPathXmlApplicationContext("applicationContext.xml");
    	UtenteDaoImpl dao = (UtenteDaoImpl) context.getBean("utenteDao");
    	
        Utente name1 = new Utente("aaaa", "bbbb", "utente");
        Utente name2 = new Utente("cccc", "dddd", "amministratore");
        
        dao.save(name1);
        dao.save(name2);
        
        List<Utente> utenti = dao.getAll();
        for (Utente utente : utenti) {
			System.out.println(utente);
		}
        context.close();
    }
/*    
	SessionFactory sf = HibernateUtil.getSessionFactory();

	int iduff = 0;
	
	// Inserimento
	Session session = sf.openSession();
	session.beginTransaction();	
	int delIdapp = 0; //definisco l'id dell'app. che cancellerò
	try {
        Applicazione app1 = new Applicazione("SAP", "Sistema gestionale");
        Applicazione app2 = new Applicazione("GIS", "Sistemi territoriali");
        session.save(app1);
        session.save(app2);
        delIdapp = app1.getAppid();

		Utente ute1 = new Utente("Franco", "Neri", "Utente");
		Utente ute2 = new Utente("Giovanni", "Bianchi", "Admin");	
				
		ute1.getApplicazioni().add(app1);
		ute1.getApplicazioni().add(app2);
		ute2.getApplicazioni().add(app1);
		ute2.getApplicazioni().add(app2);
		session.save(ute1);
		session.save(ute2);

		session.getTransaction().commit();
	}catch (HibernateException e) {
		session.getTransaction().rollback();
    	e.printStackTrace();
	} finally {
		session.close();
	}
	
	Lista(); 

	// Cancello una applicazione e tutti gli utenti associati
	session = sf.openSession();
	session.beginTransaction();			
	try {	
		 Applicazione appx = (Applicazione) session.load(Applicazione.class, delIdapp);
		 List<Utente> utenti = session.createQuery("from Utente").list();
			 for (Utente utex : utenti) {
				 utex.getApplicazioni().remove(appx);
				 session.save(utex);
			 } 
			 session.delete(appx);
		

		session.getTransaction().commit();	
	}catch (HibernateException e) {
		session.getTransaction().rollback();
    	e.printStackTrace();
	} finally {
		 session.close();
	}
	 
	 Lista(); 		

}

@SuppressWarnings("unchecked")
public static void Lista() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();	
	System.out.println("Lista utenti ufficio");
	List<Utente> uts = session.createQuery("from Utente").list();
	for (Utente ut1 : uts) {
		System.out.println(ut1.getNome()  + " , "
			+ ut1.getCognome() + ", "
			+ ut1.getRuolo()); 
			for(Applicazione appy : ut1.getApplicazioni()) {
                System.out.println("Employee Name " + appy.getNomeapp());
            }
	        
	}
	session.close();
}
    
    */
    
    
}
