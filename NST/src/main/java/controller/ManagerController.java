package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exception.NoSuchElementFoundException;
import model.Manager;
import service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@RequestMapping(value = "/login/{managerId}", method = RequestMethod.GET)
	public Manager getManager(@PathVariable Integer managerId) {
		return managerService.getManager(managerId);

	}

	@ExceptionHandler(NoSuchElementFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

}
