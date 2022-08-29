package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.impl.ManagerDto;
import service.ManagerService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

	@Autowired
	private ManagerService managerService;


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody ManagerDto m) {
		
        ManagerDto managerDto =  managerService.login(m);
        if(managerDto!=null) {
        	return ResponseEntity.ok()
        			.body(managerDto);
        } else {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials!");
        }
	}
	
	
}
