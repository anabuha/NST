package service;

import model.Manager;

public interface ManagerService {
 
	Manager getManager(int managerId);
	
	Manager login(Manager m);
}
