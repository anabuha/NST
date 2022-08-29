package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.impl.EmployeeDto;
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
	public List<EmployeeDto> getAllEmployees(int managerId) {

		Manager m = managerRepo.findById(managerId).orElse(null);

		List<EmployeeDto> employees = new ArrayList<EmployeeDto>();
		ModelMapper mapper = new ModelMapper();

		if (m != null && m.getEmployees() != null) {
			for (Employee empl : m.getEmployees()) {
				EmployeeDto emplDto = mapper.map(empl, EmployeeDto.class);
				employees.add(emplDto);
			}
		}

		return employees;
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepo.deleteById(employeeId);
	}

	@Override
	public void addNewEmployee(EmployeeDto employeeDto) {
		ModelMapper mapper = new ModelMapper();
		Employee newEmpl = mapper.map(employeeDto, Employee.class);
		employeeRepo.save(newEmpl);
	}

	@Override
	public void updateEmployee(EmployeeDto employeeDto, int id) {
		ModelMapper mapper = new ModelMapper();
		Employee updateEmpl = mapper.map(employeeDto, Employee.class);
		
		Employee old = employeeRepo.findById(id).orElse(null);
		updateEmpl.setEmployeeId(old.getEmployeeId());
		employeeRepo.save(updateEmpl);
	}

}
