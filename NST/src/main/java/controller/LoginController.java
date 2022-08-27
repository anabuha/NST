package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Manager;
import service.ManagerService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

	@Autowired
	private ManagerService managerService;


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Manager m) {
		
        Manager manager =  managerService.login(m);
        if(manager!=null) {
        	return ResponseEntity.ok()
        			.body(manager);
        } else {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials!");
        }
	}
	
	
}
