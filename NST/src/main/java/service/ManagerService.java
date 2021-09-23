package service;

import org.springframework.stereotype.Component;

import model.Manager;

public interface ManagerService {
 
	Manager getManager(int managerId);
}
