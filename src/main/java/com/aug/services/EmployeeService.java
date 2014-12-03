package com.aug.services;

import com.aug.daos.EmployeeDao;
import com.aug.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public boolean hasAuthentication(Employee employee) {
        List<Employee> employees = employeeDao.findUserByEmailPassword(employee);
        return (employees.size() > 0) ? true : false;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }	

	public void save(Employee employee)
	{
		employeeDao.save(employee);
	}

}
