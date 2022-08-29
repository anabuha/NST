package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.impl.EmployeeDto;
import service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestHeader("id") int managerId) {
		List<EmployeeDto> employeesDto = employeeService.getAllEmployees(managerId);
		
		return ResponseEntity.status(HttpStatus.OK).body(employeesDto);
	}
	
	
	@RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestHeader int id){
		try {
			employeeService.deleteEmployee(id);
			return ResponseEntity.status(HttpStatus.OK).body("Employee with id " +  id + " is deleted!");
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
    }
   
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Object> addOrUpdate(@RequestHeader(required = false) Integer id,
			@RequestBody EmployeeDto employee) {
		try {
			String message = "";
			if (id == null) {
				employeeService.addNewEmployee(employee);
				message = "Added successfully new employee!";
			} else {
				employeeService.updateEmployee(employee, id);
				message = "Employee " +employee.getEmployeeName()+" successfully updated.";
			}
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}
}
