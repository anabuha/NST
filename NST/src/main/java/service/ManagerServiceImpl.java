package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.NoSuchElementFoundException;
import model.Manager;
import repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService{

	
	@Autowired
	ManagerRepository managerRepository;

	@Override
	public Manager getManager(int managerId) {
		Manager m = managerRepository.findById(managerId).orElse(null);
		
		if(m == null) {
			throw new NoSuchElementFoundException("Manager with id "+managerId+" doesn't exist");
		}
		
		return m;
	}
	
	
}
