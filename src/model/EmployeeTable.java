package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * @mmmaimankarae
 */

public class EmployeeTable {
    public static void InsertEmployee(Employee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void UpdateEmployee(Employee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        Employee fromDb = em.find(Employee.class, emp.getEmployeeid());
        fromDb.setName(emp.getName());
        fromDb.setSalary(emp.getSalary());
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
    
    public static Employee FindEmployeeById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        Employee emp = em.find(Employee.class, id);
        em.close();
        return emp;
    }
    
    public static List<Employee> FindAllEmployee() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        List<Employee> empList = (List<Employee>) em.createNamedQuery("Employee.findAll").getResultList();
        em.close();
        return empList;
    }
    
    public static List<Employee> FindEmployeeByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Employee.findByName");
        query.setParameter("name", name);
        List<Employee> empList = (List<Employee>) query.getResultList();
        em.close();
        return empList;
    }
    
    public static void RemoveEmployee(Employee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentPU");
        EntityManager em = emf.createEntityManager();
        Employee fromDb = em.find(Employee.class, emp.getEmployeeid());
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
