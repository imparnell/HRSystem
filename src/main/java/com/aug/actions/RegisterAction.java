package com.aug.actions;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.aug.entities.Employee;
import com.aug.services.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

@ResultPath(value = "/")
public class RegisterAction extends ActionSupport{

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
	
    @Action(value = "register", results = {@Result(name = "success", location = "pages/welcome.jsp")})
    public String execute() {
    	employeeService.save(employee);
        return "success";
    }
    
    @Action(value = "initRegister", results = {@Result(name = "input", location = "pages/register.jsp")})
    public String init() {
        return INPUT;
    }
}
