package it.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.test.dao.PersonDaoImpl;
import it.test.entity.Person;

/**
 * Metodo per testare la app
 * 
 * @author Mauro Cognolato
 */
public class App {
	
    public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new  
    			  ClassPathXmlApplicationContext("applicationContext.xml");
    	PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");
    	
        Person name1 = new Person("aaaa", "bbbb");
        Person name2 = new Person("cccc", "dddd");
        
        dao.save(name1);
        dao.save(name2);
        
        List<Person> persons = dao.getAll();
        for (Person person : persons) {
			System.out.println(person);
		}
        context.close();
    }
}
