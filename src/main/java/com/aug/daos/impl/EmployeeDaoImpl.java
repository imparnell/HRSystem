package com.aug.daos.impl;

import com.aug.daos.EmployeeDao;
import com.aug.entities.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Employee> findUserByEmailPassword(Employee employee) {
        String hql = "FROM Employee emp WHERE emp.email = :email and emp.password = :password";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("email", employee.getEmail());
        query.setParameter("password", employee.getPassword());

        return query.list();
    }

    @Override
    public void save(Employee employee) {
        getCurrentSession().persist(employee);
    }

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
