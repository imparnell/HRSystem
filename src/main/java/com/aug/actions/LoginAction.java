package com.aug.actions;

import com.aug.entities.Employee;
import com.aug.services.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

@ResultPath(value = "/")
public class LoginAction extends ActionSupport {

    @Autowired
    private EmployeeService employeeService;
    private Employee employee;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployee() {
		return employee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Action(value = "login", results = {@Result(name = "input", location = "pages/login.jsp"), @Result(name = "welcome", location = "pages/welcome.jsp")})
    public String execute() {
        if (employeeService.hasAuthentication(employee)) return "welcome";
        return "input";
    }

    @Action(value = "initLogin", results = {@Result(name = "input", location = "pages/login.jsp")})
    public String init() {
        return INPUT;
    }
    
}