package repository;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Optional;

/**
 * Created by leiko on 24/09/15.
 */
public class EmployeeRepository {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public Optional<Employee> findOneByName(String name) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Optional<Employee> employee = Optional.empty();
        try {
            employee = Optional.of(manager.createQuery("SELECT e from Employee e WHERE e.name = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult());

        } catch (Exception e) {
            // TODO better exception handling
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return employee;
    }
}
