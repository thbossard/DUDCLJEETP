package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import repository.EntityManagerHelper;
import domain.Heater;

public class DAOHeater extends EntityManagerHelper{
	
	public void createHeater(List<Heater> lstHeater){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			
			for(Heater h : lstHeater){
				System.out.println("Ajouter un appareil " + h.toString());
				em.persist(h);
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
	// add heater
	public Heater createHeater(String nameH, int consoH){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		Heater heater = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			heater=new Heater(nameH,consoH);
			System.out.println("Ajouter un appareil de chauffage" + heater +toString());
			em.persist(heater);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Erreur : annulation des modifications");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
		return heater;
	}
	// delete active recordset heater
	public void deleteHeater(Heater activeH){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			em.remove(activeH);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Erreur : annulation des modifications");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
	}
	//
	public void deleteHeater(String id){
		deleteHeater(findById(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<Heater> findAll(){
		EntityManager em = getEntityManager();  
		List<Heater> results = null;
		try{
		
			results = em.createQuery("select h from Heater h").getResultList();
			
		}catch(Exception re)
		{
			System.out.println("Erreur : annulation des changements");
		}finally{
			closeEntityManager();
		}
		System.out.println("sortie de getALL()");
		return results;
	}

	public Heater findById(String id){
		EntityManager em = getEntityManager();  
		Heater instance = null;
		try{
			instance = em.find(Heater.class, id);
		}catch (RuntimeException re){
		throw re;
		}finally{
			closeEntityManager();
		}
		
		return instance;
		
	}
	
	public Heater update (Heater h) {
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			em.merge(h);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Erreur : annulation des changements");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
		return h;
	}
}