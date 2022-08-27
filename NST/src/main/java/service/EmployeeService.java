package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
  
	List<Employee> getAllEmployees(int managerId);
	
	void deleteEmployee(int employeeId);
	
	void addNewEmployee(Employee employee);
	
	void updateEmployee(Employee employee, int id);
}
