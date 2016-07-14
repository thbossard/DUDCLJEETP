package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import repository.EntityManagerHelper;
import domain.ElecDevices;

public class DAOElecDevices extends EntityManagerHelper{
	
	public void createElecDevices(List<ElecDevices> lstElecDevices){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			
			for(ElecDevices h : lstElecDevices){
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
	public ElecDevices createElecDevices(String nameED, int consoED){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		ElecDevices Ed = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			Ed=new ElecDevices(nameED,consoED);
			System.out.println("Ajouter un appareil electronique" + Ed+toString());
			em.persist(Ed);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Erreur : annulation des modifications");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
		return Ed;
	}
	// delete active recordset ElecDevices
	public void deleteElecDevices(ElecDevices activeED){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			em.remove(activeED);;
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
	public void deleteElecDevices(String id){
		deleteElecDevices(findById(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<ElecDevices> findAll(){
		EntityManager em = getEntityManager();  
		List<ElecDevices> results = null;
		try{
		
			results = em.createQuery("select Ed from ElecDevices Ed").getResultList();
			
		}catch(Exception re)
		{
			System.out.println("Erreur : annulation des changements");
		}finally{
			closeEntityManager();
		}
		System.out.println("sortie de getALL()");
		return results;
	}

	public ElecDevices findById(String id){
		EntityManager em = getEntityManager();  
		ElecDevices instance = null;
		try{
			instance = em.find(ElecDevices.class, id);
		}catch (RuntimeException re){
		throw re;
		}finally{
			closeEntityManager();
		}
		
		return instance;
		
	}
	
	public ElecDevices update (ElecDevices Ed) {
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			em.merge(Ed);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null)
				System.out.println("Erreur : annulation des changements");
			tx.rollback();
		}finally{
			closeEntityManager();
		}
		return Ed;
	}
}