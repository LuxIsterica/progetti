package it.prime.faces.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import it.jpa.data.Employee;
import it.spring.service.EmployeeService;

@ManagedBean(name="registerEmployee")
@ViewScoped
public class RegisterEmployee {

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private Employee employee = new Employee();

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String register() {
		// Chiamo la Business Service
		Date date = new Date();
		employee.setEmployeeHireDate(date);
		employeeService.register(employee);
		// Aggiornamento del messaggio non funziona su browser Eclipse.
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("The Employee  Is Registered Successfully"));
		return "index";
	}
}
