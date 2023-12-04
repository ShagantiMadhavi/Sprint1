package com.hibernate.project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeeDAO {

    private final EntityManagerFactory emf;

    public EmployeeDAO() {
        this.emf = Persistence.createEntityManagerFactory("employee-jpa");
    }

    public void saveEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            if (employee.getEmpId() == 0) {
                // If empId is 0, it's a new employee, persist it
                em.persist(employee);
            } else {
                // If empId is not 0, it's an existing employee, merge it
                em.merge(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    

    public Employee getEmployeeById(int empId) {
        EntityManager em = emf.createEntityManager();
        Employee employee = null;

        try {
            employee = em.find(Employee.class, empId);
        } finally {
            em.close();
        }

        return employee;
    }


    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("FROM Employee");
        return query.getResultList();
    }

    public void updateEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(employee); // Use merge instead of persist for updates
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public void deleteEmployee(int empId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Employee employee = em.find(Employee.class, empId);
            if (employee != null) {
                em.remove(employee);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
