package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * @mmmaimankarae
 */

public class DepartmentTable {
    public static void InsertDepartment(Department dep) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(dep);
            em.getTransaction().commit();
        } 
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } 
        finally {
            em.close();
        }
    }
    
    
    public static void UpdateDepartment (Department dep) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        Department fromDb = em.find(Department.class, dep.getDepartmentid());
        fromDb.setName(dep.getName());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static Department FindDepartmentById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        Department dep = em.find(Department.class, id);
        em.close();
        return dep;
    }

    public static List<Department> FindAllDepartment() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        List<Department> depList = (List<Department>) em.createNamedQuery("Department.findAll").getResultList();
        em.close();
        return depList;
    }

    public static List<Department> FindDepartmentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Department.findByName");
        query.setParameter("name", name);
        List<Department> depList = (List<Department>) query.getResultList();
        em.close();
        return depList;
    }

    public static void RemoveDepartment(Department dep) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        Department fromDb = em.find(Department.class, dep.getDepartmentid());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }           
    }
}
