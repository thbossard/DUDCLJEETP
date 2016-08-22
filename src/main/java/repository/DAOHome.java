package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import repository.EntityManagerHelper;
import domain.ElecDevices;
import domain.Heater;
import domain.Home;
import domain.Person;

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
	public void deleteHome(int id){
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

	public Home findById(int homeId){
		EntityManager em = getEntityManager();  
		Home instance = null;
		try{
			instance = em.find(Home.class, homeId);
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
	
	public Home createHomeDevice(int deviceId, String deviceName, int deviceAvConso){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		Home home = findById(deviceId);
			try{
				tx = em.getTransaction();
				tx.begin();
				
				ElecDevices d = new ElecDevices( deviceName, deviceAvConso );
				home.addHomeElecDevices(d);
				em.merge(home);
				tx.commit();
			}catch(Exception re)
			{
				if(tx!=null){
					tx.rollback();
				}
			}finally{
				closeEntityManager();
			}
		return home;
	}
		
	public Home createHomeHeater(int heaterId, String heaterName, int heaterConso){
		EntityManager em = getEntityManager();  
		EntityTransaction tx = null;
		Home home = findById(heaterId);
			try{
				tx = em.getTransaction();
				tx.begin();
				Heater h = new Heater( heaterName, heaterConso );
				home.addHomeHeaters(h);
				em.merge(home);
				tx.commit();
			}catch(Exception re)
			{
				if(tx!=null){
					tx.rollback();
				}
			}finally{
				closeEntityManager();
			}
		return home;
	}
	
	
	public List<Home> findByPersonId(String id){
		EntityManager em = getEntityManager();  
		Person instance = null;
		List<Home> homes = null;
		try{
			instance = em.find(Person.class, id);
			if (instance != null)
				homes = instance.getPersonHomes();
		}catch (RuntimeException re){
		throw re;
		}finally{
			closeEntityManager();
		}
		return homes;
	}
}