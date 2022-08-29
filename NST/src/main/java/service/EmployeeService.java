package service;

import java.util.List;

import dto.impl.EmployeeDto;
import model.Employee;

public interface EmployeeService {
  
	List<EmployeeDto> getAllEmployees(int managerId);
	
	void deleteEmployee(int employeeId);
	
	void addNewEmployee(EmployeeDto employee);
	
	void updateEmployee(EmployeeDto employee, int id);
}
