package jpa;

import domain.Department;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Department d = new Department();
			d.setName("yolo");
			manager.persist(d);

			Employee e = new Employee();
			e.setName("John");
			e.setDepartment(d);
			manager.persist(e);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		factory.close();
	}

}
