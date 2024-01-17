package com.employeemgmt.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DepartmentDAO {
    private final SessionFactory sessionFactory;

    public DepartmentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveDepartment(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        }
    }

    public void updateDepartment(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        }
    }

    public void deleteDepartment(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(department);
            transaction.commit();
        }
    }

    public Department getDepartmentById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Department.class, id);
        }
    }
}