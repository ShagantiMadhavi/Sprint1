package com.employeemgmt.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDAO {
    private final SessionFactory sessionFactory;

    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public void updateEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    public void deleteEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }

    public Employee getEmployeeById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, id);
        }
    }
    
    
   
    
}
