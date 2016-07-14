package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import repository.EntityManagerHelper;
import domain.Home;

public class DAOHome extends EntityManagerHelper{
	
	public void createHome(List<Home> lstHome){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			
			for(Home Ho : lstHome){
				System.out.println("Ajouter un bien immobilier " + Ho.toString());
				em.persist(Ho);
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
	public Home createHome(String nameHo,String typeHo,int sizeHo,int roomCountHo){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		Home Ho = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			Ho=new Home(nameHo,typeHo,sizeHo,roomCountHo);
			System.out.println("Ajouter un bien immobilier " + Ho+toString());
			em.persist(Ho);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Erreur : annulation des modifications");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
		return Ho;
	}
	// delete active recordset Home
	public void deleteHome(Home activeHo){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			em.remove(activeHo);;
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
	//
	public void deleteHome(String id){
		deleteHome(findById(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<Home> findAll(){
		EntityManager em = getEntityManager();  
		List<Home> results = null;
		try{
		
			results = em.createQuery("select Ho from Home Ho").getResultList();
			
		}catch(Exception re)
		{
			System.out.println("Erreur : annulation des changements");
		}finally{
			closeEntityManager();
		}
		System.out.println("sortie de getALL()");
		return results;
	}

	public Home findById(String id){
		EntityManager em = getEntityManager();  
		Home instance = null;
		try{
			instance = em.find(Home.class, id);
		}catch (RuntimeException re){
		throw re;
		}finally{
			closeEntityManager();
		}
		
		return instance;
		
	}
	
	public Home update (Home Ho) {
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			em.merge(Ho);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Erreur : annulation des changements");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
		return Ho;
	}
}