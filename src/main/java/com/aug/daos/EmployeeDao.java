package com.aug.daos;

import com.aug.entities.Employee;

import java.util.List;

public interface EmployeeDao {
	
	
    public List<Employee> findUserByEmailPassword(Employee employee);

    public void save(Employee employee);
}
