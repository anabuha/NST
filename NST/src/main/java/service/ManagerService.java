package service;

import dto.impl.ManagerDto;
import model.Manager;

public interface ManagerService {
 
	Manager getManager(int managerId);
	
	ManagerDto login(ManagerDto m);
}
