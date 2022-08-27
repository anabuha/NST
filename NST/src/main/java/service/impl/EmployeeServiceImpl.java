package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Employee;
import model.Manager;
import repository.EmployeeRepository;
import repository.ManagerRepository;
import service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	ManagerRepository managerRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees(int managerId) {
		Manager m = managerRepo.findById(managerId).orElse(null);

		if (m != null && m.getEmployees() != null) {
			return m.getEmployees();
		}

		return null;
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepo.deleteById(employeeId);
	}

	@Override
	public void addNewEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee, int id) {
		Employee old = employeeRepo.findById(id).orElse(null);
		employee.setEmployeeId(old.getEmployeeId());
		employeeRepo.save(employee);
	}

}
