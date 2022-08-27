package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;
import service.EmployeeService;

@RestController
@CrossOrigin(origins = { "http://localhost:5000", "http://localhost:3000" })
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping
	public List<Employee> getAllEmployees(@RequestHeader("id") int managerId) {
		return employeeService.getAllEmployees(managerId);
	}
	
	
	@RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public void delete(@RequestHeader int id){
		employeeService.deleteEmployee(id);
    }
   
	
	@RequestMapping(value="/employee",method = RequestMethod.POST)
    public void addOrUpdate(@RequestHeader (required = false) Integer id, @RequestBody Employee employee){
		if(id == null) {
			employeeService.addNewEmployee(employee);
		} else {
			employeeService.updateEmployee(employee, id);
		}
		
    }
}
