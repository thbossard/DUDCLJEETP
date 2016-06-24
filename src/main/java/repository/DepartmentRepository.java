package repository;

import domain.Department;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public List<Department> findAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Department> departments = new ArrayList<Department>();
        try {
            departments = manager.createQuery("SELECT d from Department d", Department.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return departments;
    }
}
