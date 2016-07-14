package repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import repository.EntityManagerHelper;
import domain.Employee;
import domain.Person;

public class DAOPerson extends EntityManagerHelper{
	
	public void createPerson(List<Person> lstPersons){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			
			for(Person p : lstPersons){
				System.out.println("Ajouter une Personne " + p.toString());
				em.persist(p);
			}
			
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
			System.out.println("Erreur : annulation des changements");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
	}

	//private EntityManager createEntityManager() {
		// TODO Auto-generated method stub
		//return null;
	//}
	// add person
	public Person createPerson(String lnameP, String fnameP, String emailP){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		Person person = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			person=new Person(lnameP,fnameP, emailP);
			System.out.println("Create person" + person+toString());
			em.persist(person);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Error : canceling changes...");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
		return person;
	}
	
	
	public Optional<Person> findOneByName(String name) {
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		Optional<Person> person = Optional.empty();
		        //try {
	            person = Optional.of(em.createQuery("SELECT p from Person p WHERE p.personLName = :name", Person.class)
	                    .setParameter("name", name)
	                    .getSingleResult());

	        //} catch (Exception re){
			//	System.out.println("Error : canceling changes...");
				
			//}finally{
				closeEntityManager();
			//}
			return person;
	}
	
	
	// delete active recordset person
	public void deletePerson(Person activeP){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			em.remove(activeP);;
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Erreur : cancel changes");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
	}
	//
	public void deletePerson(String id){
		deletePerson(findById(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findAll(){
		EntityManager em = getEntityManager();  
		List<Person> results = null;
		try{
		
			results = em.createQuery("select p from Person p", Person.class).getResultList();
			
		}catch(Exception re)
		{
			System.out.println("Error : canceling changes...");
		}finally{
			closeEntityManager();
		}
		System.out.println("sortie de getALL()");
		return results;
	}

	public Person findById(String id){
		EntityManager em = getEntityManager();  
		Person instance = null;
		try{
			instance = em.find(Person.class, id);
		}catch (RuntimeException re){
		throw re;
		}finally{
			closeEntityManager();
		}
		
		return instance;
		
	}
	
	public Person update (Person p) {
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			em.merge(p);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Error : canceling changes...");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
		return p;
	}
}