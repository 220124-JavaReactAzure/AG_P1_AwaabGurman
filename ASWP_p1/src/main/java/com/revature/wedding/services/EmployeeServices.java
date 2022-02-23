/**
 * 
 */
package com.revature.wedding.services;

import java.util.List;

import com.revature.wedding.dao.EmployeeDAO;
import com.revature.wedding.models.Employee;
import com.revature.wedding.models.EmployeesType;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
public class EmployeeServices {
	private final EmployeeDAO employeeDAO;
	/**
	 * 
	 */
	public EmployeeServices(EmployeeDAO employeeDAO) {
		// TODO Auto-generated constructor stub
		this.employeeDAO = employeeDAO;
	}

	
	
	
	public boolean addEmployee(Employee employee) {
		
		return employeeDAO.create(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDAO.selectAll();
		
	}
	
	public Employee getEmployeeById(int id){
		Employee employee = employeeDAO.selectById(id);
		return employeeDAO.selectById(id);// getEmployeeById(id);
	}
	
	
	public void updatemployee(Employee employee) {
		
		employeeDAO.update(employee);// updatemployeeWithSessionMethod(employee);
	}

}
